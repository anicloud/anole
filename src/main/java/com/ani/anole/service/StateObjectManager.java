package com.ani.anole.service;

import com.ani.anole.domain.listener.StateMachineListener;
import com.ani.anole.domain.statemachine.StateMachine;
import com.ani.anole.domain.statemachine.StateObject;
import com.ani.anole.repository.ObjectStateRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zsl on 17-3-7.
 */
public class StateObjectManager {

    @Resource
    private ObjectStateRepository objectStateRepository;

    public Map<String, StateObject> stateObjects;

    public StateObjectManager(Map<String, StateObject> stateObjects) {
        this.stateObjects = stateObjects;
    }

    public StateObjectManager() {

    }

    public StateObjectManager(Map<String, StateObject> stateObjects, ObjectStateRepository objectStateRepository) {
        this.stateObjects = stateObjects;
        this.objectStateRepository = objectStateRepository;
    }

    public void putStateObject(StateObject stateObject) {
        if (stateObject == null) return;
        objectStateRepository.putStateObject(stateObject.stateObjectId, stateObject);

    }

    public void delStateObject(String stateObjectId) {
        objectStateRepository.delStateObject(stateObjectId);
    }

    public StateObject findStateObject(String stateObjectId) {
        return objectStateRepository.getStateObject(stateObjectId);
    }

}
