package com.ani.anole.service;

import com.ani.anole.domain.statemachine.StateObject;
import com.ani.anole.repository.StateObjectRepository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by zsl on 17-3-7.
 */
public class StateObjectManager {

    @Resource
    private StateObjectRepository stateObjectRepository;

    public Map<String, StateObject> stateObjects;

    public StateObjectManager(Map<String, StateObject> stateObjects) {
        this.stateObjects = stateObjects;
    }

    public StateObjectManager() {

    }

    public StateObjectManager(Map<String, StateObject> stateObjects, StateObjectRepository stateObjectRepository) {
        this.stateObjects = stateObjects;
        this.stateObjectRepository = stateObjectRepository;
    }

    public void putStateObject(StateObject stateObject) {
        if (stateObject == null) return;
        stateObjectRepository.putStateObject(stateObject.stateObjectId, stateObject);

    }

    public void delStateObject(String stateObjectId) {
        stateObjectRepository.delStateObject(stateObjectId);
    }

    public StateObject findStateObject(String stateObjectId) {
        return stateObjectRepository.getStateObject(stateObjectId);
    }

}
