package com.ani.anole.service;

import com.ani.anole.domain.listener.StateMachineListener;
import com.ani.anole.domain.statemachine.StateMachine;
import com.ani.anole.domain.statemachine.StateObject;
import com.ani.anole.repository.ObjectStateRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zsl on 17-3-7.
 */
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

    public StateObjectManager(Map<String, StateObject> stateObjects, StateMachineListener stateMachineListener, ObjectStateRepository objectStateRepository) {
        this.stateObjects = stateObjects;
        this.stateMachineListener = stateMachineListener;
        this.objectStateRepository = objectStateRepository;
    }

    public void putStateObject(StateObject stateObject) {
        if (stateObject == null) return;
        if (stateObjects.keySet().contains(stateObject.stateObjectId)) {
            boolean isChanged = checkIsStateChanged(stateObject, stateObjects.get(stateObject.stateObjectId));
            if (isChanged) listenStateObject(stateObject);
        }
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

        }
    }

    private void listenStateObject(StateObject stateObject) {
        stateMachineListener.onStateObjectEvent(stateObject);
    }

    private boolean checkIsStateChanged(StateObject stateObject1, StateObject stateObject2) {
        if (stateObject1.stateMachineIdMap.size() != stateObject2.stateMachineIdMap.size()) return true;
        for (Integer objectId : stateObject1.stateMachineIdMap.keySet()) {
            StateMachine stateMachine = stateObject1.getStateMachine(objectId);
            StateMachine stateMachine1 = stateObject2.getStateMachine(objectId);
            if (!stateMachine.currentStateNode.equals(stateMachine1.currentStateNode)) return true;
        }
        return false;
    }
}
