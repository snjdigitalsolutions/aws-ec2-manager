package com.snjdigitalsolutions.awsec2manager.trigger;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevCronTrigger implements CronTriggerGenerator {

    @Override
    public CronTrigger getCronTrigger(String hour, String minute)
    {
        return new CronTrigger("*/10 " + "* * * * *");
    }
}
