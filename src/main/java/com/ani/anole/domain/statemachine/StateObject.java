package com.ani.anole.domain.statemachine;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by zsl on 17-3-6.
 */
public class StateObject  implements Serializable {

    public String stateObjectId;

    public Map<Integer, StateMachine> stateMachineIdMap;

    public Long timestamp;


    public StateObject(String stateObjectId, Map<Integer, StateMachine> stateMachineIdMap, Long timetmp) {
        this.stateObjectId = stateObjectId;
        this.stateMachineIdMap = stateMachineIdMap;
        this.timestamp = timetmp;
    }

    public StateObject() {
    }

    public StateMachine getStateMachine(Integer machineId) {
        return stateMachineIdMap.get(machineId);
    }
}
