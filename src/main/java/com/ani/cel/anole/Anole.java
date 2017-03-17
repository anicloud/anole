package com.ani.cel.anole;

import com.ani.cel.anole.domain.statemachine.StateObject;
import com.ani.cel.anole.service.StateObjectManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zsl on 17-3-7.
 */
public class Anole {

    private Map<String, StateObject> stateObjects;

    private StateObjectManager stateObjectManager;

    public Anole() {
    }

    public Anole(Map<String, StateObject> stateObjects) {
        this.stateObjects = stateObjects;
        initStateObjectManager();
    }

    public Anole(int expStateObjectContainerSize) {
        this.stateObjects = new HashMap<>(expStateObjectContainerSize, 0.9f);
        initStateObjectManager();
    }

    private void initStateObjectManager() {
        this.stateObjectManager = new StateObjectManager(this.stateObjects);
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
