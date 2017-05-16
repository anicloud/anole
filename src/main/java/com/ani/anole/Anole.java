package com.ani.anole;

import com.ani.anole.domain.listener.StateMachineListener;
import com.ani.anole.repository.ObjectStateRepository;
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


    private ObjectStateRepository objectStateRepository;

    public Anole() {

    }

    public Anole(int expStateObjectContainerSize) {
        this.statesObject = new HashMap<>(expStateObjectContainerSize, 0.9f);
        initStateObjectManager();
    }

    public Anole(Map statesObject, ObjectStateRepository objectStateRepository) {
        this.statesObject = statesObject;
        this.objectStateRepository = objectStateRepository;
        initStateObjectManager();
    }

    private void initStateObjectManager() {
        this.stateObjectManager = new StateObjectManager(this.statesObject, this.objectStateRepository);
    }

    public StateObject getStateObject(Long masterId, Integer slaveId) {
        String objectId = masterId + ":" + slaveId;
        return this.stateObjectManager.findStateObject(objectId);
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
