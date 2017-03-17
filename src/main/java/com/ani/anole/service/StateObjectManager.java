package com.ani.anole.service;

import com.ani.anole.domain.listener.StateMachineListener;
import com.ani.anole.domain.statemachine.StateObject;
import com.ani.anole.repository.ObjectStateRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zsl on 17-3-7.
 */
@Component
public class StateObjectManager {

    private static Long TIME_TRIGGER = 100000l;

    private StateMachineListener stateMachineListener;

    private ObjectStateRepository objectStateRepository;

    public Map<String, StateObject> stateObjects;

    public StateObjectManager() {
        this.stateObjects = new HashMap<>(100, 0.9f);
    }

    public StateObjectManager(Map<String, StateObject> stateObjects) {
        this.stateObjects = stateObjects;
    }

    public void putStateObject(StateObject stateObject) {
        if (stateObject == null) return;
        stateObjects.put(stateObject.stateObjectId, stateObject);
    }

    public void delStateObject(String stateObjectId) {
        stateObjects.remove(stateObjectId);
    }

    public StateObject findStateObject(String stateObjectId) {
        return stateObjects.get(stateObjectId);
    }

    private void triggerUpdateObject() {
        Long time = System.currentTimeMillis();
        for (String objectId : stateObjects.keySet()
                ) {
            if (stateObjects.get(objectId).timestamp - time > TIME_TRIGGER) updateStateObject(objectId);
        }
    }

    private void updateStateObject(String objectId) {
        if (objectStateRepository != null) {
            this.putStateObject(objectStateRepository.getObjectState(objectId));
            listenStateObject(objectId);
        }
    }

    private void listenStateObject(String objectId) {
        stateMachineListener.onStateObjectEvent(objectStateRepository.getObjectState(objectId));
    }
}
