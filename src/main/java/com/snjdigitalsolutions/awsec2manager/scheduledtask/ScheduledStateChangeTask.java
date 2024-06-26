package com.snjdigitalsolutions.awsec2manager.scheduledtask;

import com.snjdigitalsolutions.awsec2manager.decision.State;
import org.springframework.scheduling.support.CronTrigger;

public interface ScheduledStateChangeTask extends Runnable {

    void populateTaskParameters(String instanceId, State desiredState, String region);

}
