package com.snjdigitalsolutions.awsec2manager.configuration;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
                if (isLineValid(inLine))
                {
                    HostConfiguration hostConfiguration = new HostConfiguration();
                    String[] tokens = inLine.split("\\|");
                    hostConfiguration.setInstanceId(tokens[0].trim());
                    hostConfiguration.setStartTime(tokens[1].trim());
                    hostConfiguration.setEndTime(tokens[2].trim());
                    hostConfiguration.setRegion(tokens[3].trim());
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

    private Boolean isLineValid(String line)
    {
        boolean valid = false;
        if(!line.startsWith("#")
                && !line.isEmpty()
                && line.matches("[a-zA-B0-9-]+ \\| [a-zA-B0-9-]+ \\| [a-zA-B0-9-]+ \\| [a-zA-B0-9-]+")
        )
        {
            valid = true;
        }
        return valid;
    }

}
