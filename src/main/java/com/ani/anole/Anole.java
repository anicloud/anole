package com.ani.anole;

import com.ani.anole.repository.StateObjectRepository;
import com.ani.anole.service.StateObjectManager;
import com.ani.anole.domain.statemachine.StateObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zsl on 17-3-7.
 */
@Component
public class Anole {

    private Map<String, StateObject> statesObject;

    @Resource
    private StateObjectManager stateObjectManager;


    private StateObjectRepository stateObjectRepository;

    public Anole() {

    }

    public Anole(int expStateObjectContainerSize) {
        this.statesObject = new HashMap<>(expStateObjectContainerSize, 0.9f);
        initStateObjectManager();
    }

    public Anole(Map statesObject, StateObjectRepository stateObjectRepository) {
        this.statesObject = statesObject;
        this.stateObjectRepository = stateObjectRepository;
        initStateObjectManager();
    }

    private void initStateObjectManager() {
        this.stateObjectManager = new StateObjectManager(this.statesObject, this.stateObjectRepository);
    }

    public StateObject getStateObject(Long masterId, Integer slaveId) {
        String objectId = masterId + ":" + slaveId;
        StateObject stateObject = this.stateObjectManager.findStateObject(objectId);
        return stateObject==null?new StateObject():stateObject;
    }

    public StateObject getStateObject(String objectId) {
        return this.stateObjectManager.findStateObject(objectId);
    }

    public void delSateObject(String objectId) {
        this.stateObjectManager.delStateObject(objectId);
    }

    public void putStateObject(StateObject stateObject) {
        this.stateObjectManager.putStateObject(stateObject);
    }

}
