package com.ani.cel.anole.domain.statemachine;

/**
 * Created by zsl on 17-3-6.
 */
public abstract class StateTransferTrigger {

    public StateMachineNode nextStateMachineNode;

    public StateTransferTrigger() {
    }

    public StateTransferTrigger(StateMachineNode nextStateMachineNode) {
        this.nextStateMachineNode = nextStateMachineNode;
    }

    public abstract StateMachineEvents checkStateTransfer();

}
