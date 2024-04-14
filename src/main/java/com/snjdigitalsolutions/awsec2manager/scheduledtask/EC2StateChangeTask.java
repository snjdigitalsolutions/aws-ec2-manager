package com.snjdigitalsolutions.awsec2manager.scheduledtask;

import com.snjdigitalsolutions.awsec2manager.decision.State;
import com.snjdigitalsolutions.awsec2manager.ec2.EC2StartStop;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EC2StateChangeTask implements ScheduledStateChangeTask {

    private final EC2StartStop ec2StartStop;
    private String instanceId;
    private State desiredState;
    private String awsRegion;

    public EC2StateChangeTask(EC2StartStop ec2StartStop)
    {
        this.ec2StartStop = ec2StartStop;
    }

    @Override
    public void run()
    {
        Boolean success = ec2StartStop.setInstanceState(instanceId, desiredState, awsRegion);
        if (!success)
        {
            //TODO Add some logging here
            System.out.println("Failed to set instance state");
        }
    }

    @Override
    public void populateTaskParameters(String instanceId, State desiredState, String region)
    {
        this.instanceId = instanceId;
        this.desiredState = desiredState;
        this.awsRegion = region;
    }
}
