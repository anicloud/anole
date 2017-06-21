package com.ani.anole.domain.statemachine;

import java.io.Serializable;

/**
 * Created by zsl on 17-3-6.
 */
public abstract class StateTransferTrigger implements Serializable {

    private static final long serialVersionUID = -7000316988403333222L;
    public StateMachineNode nextStateMachineNode;

    public StateTransferTrigger() {
    }

    public StateTransferTrigger(StateMachineNode nextStateMachineNode) {
        this.nextStateMachineNode = nextStateMachineNode;
    }

    public abstract StateMachineEvents checkStateTransfer();

}
