package com.snjdigitalsolutions.awsec2manager.utility;

import java.time.format.DateTimeFormatter;


public class TimeUtility {

    private static final DateTimeFormatter twnetyFourHourTimeFormatter = DateTimeFormatter.ofPattern("kkmm");

    public static DateTimeFormatter timeFormatter()
    {
        return twnetyFourHourTimeFormatter;
    }

}
