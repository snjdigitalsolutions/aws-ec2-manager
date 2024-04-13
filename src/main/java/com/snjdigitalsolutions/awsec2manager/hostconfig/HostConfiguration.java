package com.snjdigitalsolutions.awsec2manager.hostconfig;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HostConfiguration {

    private String instanceId;
    private String startTime;
    private String endTime;
    private String region;

}
