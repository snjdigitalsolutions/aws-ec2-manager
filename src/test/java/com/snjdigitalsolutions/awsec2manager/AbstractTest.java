package com.snjdigitalsolutions.awsec2manager;

import com.snjdigitalsolutions.awsec2manager.configuration.HostConfigurationParser;
import com.snjdigitalsolutions.awsec2manager.decision.StateDecision;
import com.snjdigitalsolutions.awsec2manager.ec2.EC2List;
import com.snjdigitalsolutions.awsec2manager.ec2.EC2StartStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractTest {

    @Autowired
    protected HostConfigurationParser parser;

    @Autowired
    protected StateDecision stateDecision;

    @Autowired
    protected EC2List EC2List;

    @Autowired
    protected EC2StartStop ec2StartStop;

}
