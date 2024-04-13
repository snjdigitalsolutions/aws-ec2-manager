package com.snjdigitalsolutions.awsec2manager.decision;

import com.snjdigitalsolutions.awsec2manager.configuration.HostConfiguration;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class StateDecision {

    public State makeDecisionForHostConfiguration(HostConfiguration hostConfiguration, LocalTime... currentTime)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("kkmm");
        LocalTime nowInUTC = LocalTime.now(ZoneId.of("Z"));
        if (currentTime.length > 0)
        {
            nowInUTC = currentTime[0];
        }
        LocalTime startTime = LocalTime.parse(hostConfiguration.getStartTime(), formatter);
        LocalTime endTime = LocalTime.parse(hostConfiguration.getEndTime(), formatter);
        State state = State.STOP;
        if (nowInUTC.isAfter(startTime) && nowInUTC.isBefore(endTime))
        {
            state =  State.START;
        }
        return state;
    }

}