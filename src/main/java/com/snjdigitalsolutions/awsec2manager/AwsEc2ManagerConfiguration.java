package com.snjdigitalsolutions.awsec2manager;

import com.snjdigitalsolutions.awsec2manager.scheduledtask.ClearableThreadPoolTaskScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class AwsEc2ManagerConfiguration {

    @Bean
    public ClearableThreadPoolTaskScheduler ec2Scheduler()
    {
        ClearableThreadPoolTaskScheduler scheduler = new ClearableThreadPoolTaskScheduler();
        scheduler.setPoolSize(5);
        scheduler.setThreadNamePrefix("aws-ec2-state-");
        return scheduler;
    }


}
