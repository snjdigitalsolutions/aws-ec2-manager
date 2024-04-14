package com.snjdigitalsolutions.awsec2manager.ec2;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IPtoIDMapper {

    private Map<String,String> ipToIdMap;

    public IPtoIDMapper()
    {
        this.ipToIdMap = new HashMap<>();
    }

    public void addMapping(String ip, String id)
    {
        ipToIdMap.put(ip,id);
    }

    public String getIdForIp(String ip)
    {
        return ipToIdMap.get(ip);
    }

    public void clearMap()
    {
        ipToIdMap.clear();
    }

}
