package com.ani.statusmachine.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zsl on 17-2-28.
 */
public class StatusGroupManager {
    private Map<String, StatusGroup> machineMap = new ConcurrentHashMap<>();

    public void addStatusMachine(StatusGroup statusGroup) {
        if (statusGroup == null) return;
        String key = statusGroup.statusgroupid.toString();
        machineMap.put(key, statusGroup);
    }

    public StatusGroup getStatusMachine(String key) {
        return machineMap.get(key);
    }

    public void removeStatusMachine(String key) {
        machineMap.remove(key);
    }
}
