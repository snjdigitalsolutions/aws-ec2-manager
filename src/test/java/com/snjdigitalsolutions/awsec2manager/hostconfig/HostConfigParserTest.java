package com.snjdigitalsolutions.awsec2manager.hostconfig;

import com.snjdigitalsolutions.awsec2manager.AbstractTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HostConfigParserTest extends AbstractTest {

    @Test
    void testParse()
    {
        // Arrange
        File testFile = new File("src/test/resources/example-host-config");
        List<HostConfiguration> configurations = null;

        // Act
        configurations = parser.parseConfiguration(testFile);

        // Assert
        assertEquals(1, configurations.size());
        assertEquals("i-09af3c430ff05e04b", configurations.get(0).getInstanceId());
        assertEquals("0600", configurations.get(0).getStartTime());
        assertEquals("1800", configurations.get(0).getEndTime());
        assertEquals("us-east-2", configurations.get(0).getRegion());

    }

}