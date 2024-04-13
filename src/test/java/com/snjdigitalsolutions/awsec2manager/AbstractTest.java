package com.snjdigitalsolutions.awsec2manager;

import com.snjdigitalsolutions.awsec2manager.configuration.HostConfigurationParser;
import com.snjdigitalsolutions.awsec2manager.decision.StateDecision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractTest {

    @Autowired
    protected HostConfigurationParser parser;

    @Autowired
    protected StateDecision stateDecision;

}
