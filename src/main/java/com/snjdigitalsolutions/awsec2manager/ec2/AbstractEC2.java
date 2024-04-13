package com.snjdigitalsolutions.awsec2manager.ec2;

import software.amazon.awssdk.regions.Region;

public class AbstractEC2 {

    protected Region selectedRegion = Region.US_EAST_1;

    public Region setRegionForTask(String regionFromConfiguration)
    {
        switch (regionFromConfiguration)
        {
            case "us-east-2":
                selectedRegion = Region.US_EAST_2;
                break;
            case "us-west-1":
                selectedRegion = Region.US_WEST_1;
                break;
            case "us-west-2":
                selectedRegion = Region.US_WEST_2;
                break;
            case "us-gov-east":
                selectedRegion = Region.US_GOV_EAST_1;
                break;
            case "us-gov-west":
                selectedRegion = Region.US_GOV_WEST_1;
                break;
        }
        return selectedRegion;
    }

}
