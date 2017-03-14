package com.ani.anole.domain.statemachine;

import com.ani.anole.domain.listener.StateMachineListener;

import java.util.Map;
import java.util.Vector;

/**
 * Created by zsl on 17-3-6.
 */
public class StateObject {

    public String stateObjectId;

    public Map<Integer, StateMachine> stateMachineIdMap;

    public StateMachineEvents event;

    public Vector<StateMachineListener> stateMachineListeners;


    public StateMachine getStateMachine(Integer machineId) {
        return stateMachineIdMap.get(machineId);
    }

    public synchronized void addListener(StateMachineListener stateMachineListener) {
        this.stateMachineListeners.addElement(stateMachineListener);
    }

    public synchronized void delListener(StateMachineListener stateMachineListener) {
        this.stateMachineListeners.remove(stateMachineListener);
    }

    public synchronized void notifyListeners() {
        for (StateMachineListener statelistener : stateMachineListeners
                ) {
            statelistener.stateTransfer(event, this);
        }
    }

}
