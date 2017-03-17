package com.ani.cel.anole.domain.statemachine;

import java.util.Map;

/**
 * Created by zsl on 17-3-6.
 */
public class StateObject {

    public String stateObjectId;

    public Map<Integer, StateMachine> stateMachineIdMap;

    public Long timestmp;

    public StateMachine getStateMachine(Integer machineId) {
        return stateMachineIdMap.get(machineId);
    }
}
