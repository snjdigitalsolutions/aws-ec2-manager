package com.snjdigitalsolutions.awsec2manager.ec2;

import com.snjdigitalsolutions.awsec2manager.decision.State;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.StartInstancesRequest;
import software.amazon.awssdk.services.ec2.model.StopInstancesRequest;

@Component
public class EC2StartStop extends AbstractEC2 {

    public Boolean setInstanceState(String instanceId, State desiredState, String region)
    {
        boolean success = false;
        setRegionForTask(region);
        try (Ec2Client client = Ec2Client.builder()
                .region(selectedRegion).build()){

            switch (desiredState)
            {
                case STOP -> {
                    stopInstance(client,instanceId);
                }
                case START -> {
                    startInstance(client,instanceId);
                }
            }
            success = true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return success;
    }

    private void startInstance(Ec2Client ec2, String instanceId) {
        StartInstancesRequest request = StartInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        ec2.startInstances(request);
        System.out.printf("Successfully started instance %s", instanceId);
    }

    private void stopInstance(Ec2Client ec2, String instanceId) {
        StopInstancesRequest request = StopInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        ec2.stopInstances(request);
        System.out.printf("Successfully stopped instance %s", instanceId);
    }

}
