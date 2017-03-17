package com.ani.anole;

import com.ani.anole.service.StateObjectManager;
import com.ani.anole.domain.statemachine.StateObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zsl on 17-3-7.
 */
public class Anole {

    private Map<String, StateObject> statesObject;

    private StateObjectManager stateObjectManager;

    public Anole() {
    }

    public Anole(Map<String, StateObject> statesObject) {
        this.statesObject = statesObject;
        initStateObjectManager();
    }

    public Anole(int expStateObjectContainerSize) {
        this.statesObject = new HashMap<>(expStateObjectContainerSize, 0.9f);
        initStateObjectManager();
    }

    private void initStateObjectManager() {
        this.stateObjectManager = new StateObjectManager(this.statesObject);
    }

    public void getStateObject(String objectId) {
        this.stateObjectManager.findStateObject(objectId);
    }

    public void delSateObject(String objectId) {
        this.stateObjectManager.delStateObject(objectId);
    }

    public void putStateObject(StateObject stateObject) {
        this.stateObjectManager.putStateObject(stateObject);
    }

}
