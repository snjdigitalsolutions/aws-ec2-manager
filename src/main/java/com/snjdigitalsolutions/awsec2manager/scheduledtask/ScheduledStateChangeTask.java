package com.snjdigitalsolutions.awsec2manager.scheduledtask;

public interface ScheduledStateChangeTask extends Runnable {

    String generateCronExpression();

}
