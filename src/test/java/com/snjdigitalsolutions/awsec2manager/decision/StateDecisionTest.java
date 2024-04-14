package com.snjdigitalsolutions.awsec2manager.decision;

import com.snjdigitalsolutions.awsec2manager.AbstractTest;
import com.snjdigitalsolutions.awsec2manager.hostconfig.HostConfiguration;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class StateDecisionTest extends AbstractTest {

    @Test
    void testStateDecision()
    {
        // Arrange
        HostConfiguration testConfiguration = new HostConfiguration();
        testConfiguration.setInstanceIP("test");
        testConfiguration.setStartTime("0600");
        testConfiguration.setStopTime("1800");

        // Act
        State decisionState = stateDecision.makeDecisionForHostConfiguration(testConfiguration, LocalTime.parse("0916", DateTimeFormatter.ofPattern("kkmm")));

        // Assert
        assertEquals(State.START, decisionState);
    }

    @Test
    void testStateDecisionBeforeStart()
    {
        // Arrange
        HostConfiguration testConfiguration = new HostConfiguration();
        testConfiguration.setInstanceIP("test");
        testConfiguration.setStartTime("0600");
        testConfiguration.setStopTime("1800");

        // Act
        State decisionState = stateDecision.makeDecisionForHostConfiguration(testConfiguration, LocalTime.parse("0500", DateTimeFormatter.ofPattern("kkmm")));

        // Assert
        assertEquals(State.STOP, decisionState);
    }

    @Test
    void testStateDecisionAfterEnd()
    {
        // Arrange
        HostConfiguration testConfiguration = new HostConfiguration();
        testConfiguration.setInstanceIP("test");
        testConfiguration.setStartTime("0600");
        testConfiguration.setStopTime("1800");

        // Act
        State decisionState = stateDecision.makeDecisionForHostConfiguration(testConfiguration, LocalTime.parse("1900", DateTimeFormatter.ofPattern("kkmm")));

        // Assert
        assertEquals(State.STOP, decisionState);
    }

}