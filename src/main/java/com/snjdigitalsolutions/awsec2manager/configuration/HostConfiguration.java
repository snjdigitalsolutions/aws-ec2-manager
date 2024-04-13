package com.snjdigitalsolutions.awsec2manager.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HostConfiguration {

    private String instanceid;
    private Integer startTime;
    private Integer endTime;

}
