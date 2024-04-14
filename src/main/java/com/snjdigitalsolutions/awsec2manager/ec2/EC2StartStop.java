package com.snjdigitalsolutions.awsec2manager.ec2;

import com.snjdigitalsolutions.awsec2manager.decision.State;

public interface EC2StartStop {

    Boolean setInstanceState(String instanceId, State desiredState, String region);

}
