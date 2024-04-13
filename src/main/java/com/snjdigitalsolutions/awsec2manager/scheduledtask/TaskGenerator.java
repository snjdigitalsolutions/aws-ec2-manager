package com.snjdigitalsolutions.awsec2manager.scheduledtask;

import com.snjdigitalsolutions.awsec2manager.hostconfig.HostConfiguration;
import com.snjdigitalsolutions.awsec2manager.hostconfig.HostConfigurationParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Generate tasks based off the configuration file
 * located at /etc/ec2manager/ec2manager.conf
 */
@Component
public class TaskGenerator {

    @Value("${ec2manager.configurationpath}")
    String configurationFilePath;

    private HostConfigurationParser hostConfigurationParser;

    public TaskGenerator(HostConfigurationParser hostConfigurationParser)
    {
        this.hostConfigurationParser = hostConfigurationParser;
    }

    public void generateTasks()
    {
        List<HostConfiguration> hostConfigurations = hostConfigurationParser.parseConfiguration(new File(configurationFilePath));

        // Map IPs to instance IDs

        for (HostConfiguration hostConfiguration : hostConfigurations)
        {
            System.out.println("Setting start task for: " + hostConfiguration.getInstanceId());
        }

    }

}
