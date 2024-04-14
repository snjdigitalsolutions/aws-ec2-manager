package com.snjdigitalsolutions.awsec2manager.ec2;

import com.snjdigitalsolutions.awsec2manager.AbstractTest;
import com.snjdigitalsolutions.awsec2manager.decision.State;
import org.junit.jupiter.api.Test;

class ProdEC2StartStopTest extends AbstractTest {


    @Test
    void startTest()
    {
        // Arrange
        State desriedState = State.START;
        String ec2InstanceId = "i-09af3c430ff05e04b";
        String region = "us-east-1";

        // Act
        prodEc2StartStop.setInstanceState(ec2InstanceId, desriedState, region);

        // Assert
    }

    @Test
    void stopTest()
    {
        // Arrange
        State desriedState = State.STOP;
        String ec2InstanceId = "i-09af3c430ff05e04b";
        String region = "us-east-1";

        // Act
        prodEc2StartStop.setInstanceState(ec2InstanceId, desriedState, region);

        // Assert
    }

}