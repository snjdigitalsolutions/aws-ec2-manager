package com.snjdigitalsolutions.awsec2manager.trigger;

import org.springframework.scheduling.support.CronTrigger;

public interface CronTriggerGenerator {

    public CronTrigger getCronTrigger(String hour, String minute);

}
