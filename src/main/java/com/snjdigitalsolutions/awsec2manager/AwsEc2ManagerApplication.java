package com.snjdigitalsolutions.awsec2manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AwsEc2ManagerApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(AwsEc2ManagerApplication.class, args);
    }

}
