package com.snjdigitalsolutions.awsec2manager.configuration;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

@Component
public class HostConfigurationParser {

    public List<HostConfiguration> parseConfiguration(File localFile){

        List<HostConfiguration> configurationList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(localFile)))
        {
            String inLine = reader.readLine();
            while(inLine != null)
            {
                inLine = inLine.trim();
                if (!inLine.startsWith("#") && !inLine.isEmpty())
                {
                    HostConfiguration hostConfiguration = new HostConfiguration();
                    String[] tokens = inLine.split("\\|");
                    hostConfiguration.setInstanceid(tokens[0].trim());
                    hostConfiguration.setStartTime(Integer.valueOf(tokens[1].trim()));
                    hostConfiguration.setEndTime(Integer.valueOf(tokens[2].trim()));
                    configurationList.add(hostConfiguration);
                }
                inLine = reader.readLine();
            }
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return  configurationList;
    }

}
