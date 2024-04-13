package com.snjdigitalsolutions.awsec2manager.ec2;

import java.util.HashMap;
import java.util.Map;

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

}
