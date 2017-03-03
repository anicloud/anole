package com.ani.statusmachine.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zsl on 17-2-28.
 * this class manager statusmachines, the key is Objectid-number
 */
public class StatusMachineMananger {
    private Map<String, StatusMachine> machineMap = new ConcurrentHashMap<>();

    public void addStatusMachine(StatusMachine statusMachine) {
        if (statusMachine == null) return;
        String key = statusMachine.objectid + "-" + statusMachine.number;
        machineMap.put(key, statusMachine);
    }

    public StatusMachine getStatusMachine(String key) {
        return machineMap.get(key);
    }

    public void removeStatusMachine(String key) {
        machineMap.remove(key);
    }
}
