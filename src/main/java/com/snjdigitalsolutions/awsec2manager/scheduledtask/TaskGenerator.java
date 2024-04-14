package com.snjdigitalsolutions.awsec2manager.scheduledtask;

import com.snjdigitalsolutions.awsec2manager.decision.State;
import com.snjdigitalsolutions.awsec2manager.ec2.EC2IPIDMapper;
import com.snjdigitalsolutions.awsec2manager.ec2.IPtoIDMapper;
import com.snjdigitalsolutions.awsec2manager.hostconfig.HostConfiguration;
import com.snjdigitalsolutions.awsec2manager.hostconfig.HostConfigurationParser;
import com.snjdigitalsolutions.awsec2manager.trigger.CronTriggerGenerator;
import com.snjdigitalsolutions.awsec2manager.utility.TimeUtility;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Generate tasks based off the configuration file
 * located at /etc/ec2manager/ec2manager.conf
 */
@Component
public class TaskGenerator implements ApplicationContextAware {

    @Value("${ec2manager.configurationpath}")
    String configurationFilePath;
    private final HostConfigurationParser hostConfigurationParser;
    private final IPtoIDMapper iPtoIDMapper;
    private final ClearableThreadPoolTaskScheduler ec2TaskScheduler;
    private final CronTriggerGenerator triggerGenerator;
    private final EC2IPIDMapper ec2IPIDMapper;

    private ApplicationContext applicationContext;

    public TaskGenerator(HostConfigurationParser hostConfigurationParser,
                         IPtoIDMapper iPtoIDMapper,
                         ClearableThreadPoolTaskScheduler ec2Scheduler,
                         CronTriggerGenerator triggerGenerator,
                         EC2IPIDMapper ec2IPIDMapper)
    {
        this.hostConfigurationParser = hostConfigurationParser;
        this.iPtoIDMapper = iPtoIDMapper;
        this.ec2TaskScheduler = ec2Scheduler;
        this.triggerGenerator = triggerGenerator;
        this.ec2IPIDMapper = ec2IPIDMapper;
    }

    public void generateTasks()
    {
        List<HostConfiguration> hostConfigurations = hostConfigurationParser.parseConfiguration(new File(configurationFilePath));
        ec2IPIDMapper.performMapping();
        ec2TaskScheduler.clearTasks();
        for (HostConfiguration hostConfiguration : hostConfigurations)
        {
            String instanceIP = hostConfiguration.getInstanceIP();
            String instanceID = iPtoIDMapper.getIdForIp(instanceIP);

            System.out.println("Setting tasks for: " + instanceIP);
            System.out.println("Setting start task for: " + hostConfiguration.getStartTime());
            System.out.println("Setting stop task for: " + hostConfiguration.getStopTime());

            LocalTime startTime = LocalTime.parse(hostConfiguration.getStartTime(), TimeUtility.timeFormatter());
            EC2StateChangeTask startTask = (EC2StateChangeTask) applicationContext.getBean("EC2StateChangeTask");
            CronTrigger startTrigger = triggerGenerator.getCronTrigger(Integer.toString(startTime.getHour()), Integer.toString(startTime.getMinute()));
            startTask.populateTaskParameters(instanceID, State.START, hostConfiguration.getRegion());
            ec2TaskScheduler.schedule(startTask,startTrigger);

            LocalTime stopTime = LocalTime.parse(hostConfiguration.getStopTime(), TimeUtility.timeFormatter());
            EC2StateChangeTask stopTask = (EC2StateChangeTask) applicationContext.getBean("EC2StateChangeTask");
            CronTrigger stopTrigger = triggerGenerator.getCronTrigger(Integer.toString(stopTime.getHour()), Integer.toString(stopTime.getMinute()));
            stopTask.populateTaskParameters(instanceID, State.STOP, hostConfiguration.getRegion());
            ec2TaskScheduler.schedule(stopTask,stopTrigger);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }
}
