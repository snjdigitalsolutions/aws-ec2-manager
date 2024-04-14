package com.snjdigitalsolutions.awsec2manager.ec2;

import com.snjdigitalsolutions.awsec2manager.decision.State;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevEC2StartStop implements EC2StartStop {
    @Override
    public Boolean setInstanceState(String instanceId, State desiredState, String region)
    {
        System.out.println("Changing state of instance:");
        System.out.println("ID: " + instanceId);
        System.out.println("State: " + desiredState);
        System.out.println("Region: " + region);
        return true;
    }
}
