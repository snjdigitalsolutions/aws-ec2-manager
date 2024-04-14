package com.snjdigitalsolutions.awsec2manager;

import com.snjdigitalsolutions.awsec2manager.hostconfig.HostConfigurationParser;
import com.snjdigitalsolutions.awsec2manager.decision.StateDecision;
import com.snjdigitalsolutions.awsec2manager.ec2.EC2IPIDMapper;
import com.snjdigitalsolutions.awsec2manager.ec2.ProdEC2StartStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractTest {

    @Autowired
    protected HostConfigurationParser parser;

    @Autowired
    protected StateDecision stateDecision;

    @Autowired
    protected EC2IPIDMapper EC2IPIDMapper;

    @Autowired
    protected ProdEC2StartStop prodEc2StartStop;

}
