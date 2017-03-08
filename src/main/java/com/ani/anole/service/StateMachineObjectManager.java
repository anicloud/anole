package com.ani.anole.service;

import com.ani.anole.domain.statemachine.StateObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zsl on 17-3-7.
 */
@Component
public class StateMachineObjectManager {
    public Map<String, StateObject> stateObjectMap = new HashMap<>();

    public void addStateObject(StateObject stateObject) {
        stateObjectMap.put(stateObject.stateObjectId, stateObject);
    }

    public void delStateObject(String stateObjectId) {
        stateObjectMap.remove(stateObjectId);
    }

    public StateObject findStateObject(String stateObjectId) {
        return stateObjectMap.get(stateObjectId);
    }
}
