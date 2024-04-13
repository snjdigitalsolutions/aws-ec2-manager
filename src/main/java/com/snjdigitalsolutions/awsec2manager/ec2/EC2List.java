package com.snjdigitalsolutions.awsec2manager.ec2;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesRequest;
import software.amazon.awssdk.services.ec2.paginators.DescribeInstancesIterable;

@Component
public class EC2List extends AbstractEC2 {

    public void getEC2Instances()
    {
        try (Ec2Client client = Ec2Client.builder()
                .region(region).build()){
            DescribeInstancesRequest request = DescribeInstancesRequest.builder()
                    .maxResults(100)
                    .build();

            DescribeInstancesIterable instancesIterable = client.describeInstancesPaginator(request);
            instancesIterable.stream()
                    .flatMap(r -> r.reservations().stream())
                    .flatMap(reservation -> reservation.instances().stream())
                    .forEach(instance -> {
                        System.out.println("Instance Id is " + instance.instanceId());
                        System.out.println("Image id is " + instance.imageId());
                        System.out.println("Instance type is " + instance.instanceType());
                        System.out.println("Instance state name is " + instance.state().name());
                        System.out.println("Monitoring information is " + instance.monitoring().state());
                        System.out.println("Instance IP is " + instance.privateIpAddress());
                    });
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
