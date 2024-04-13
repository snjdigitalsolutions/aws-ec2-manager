package com.snjdigitalsolutions.awsec2manager.configuration;

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
        assertEquals("testid", configurations.get(0).getInstanceid());
        assertEquals(600, configurations.get(0).getStartTime());
        assertEquals(1800, configurations.get(0).getEndTime());
    }

}