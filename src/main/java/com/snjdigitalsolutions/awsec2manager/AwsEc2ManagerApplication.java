package com.snjdigitalsolutions.awsec2manager;

import com.snjdigitalsolutions.awsec2manager.scheduledtask.TaskGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AwsEc2ManagerApplication implements CommandLineRunner {

    @Autowired
    private TaskGenerator taskGenerator;

    public static void main(String[] args)
    {
        SpringApplication.run(AwsEc2ManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        taskGenerator.generateTasks();
    }
}
