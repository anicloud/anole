package com.ani.anole.domain.statemachine;

import com.ani.anole.domain.statemachine.StateMachineNode;
import com.ani.octopus.commons.stub.dto.StubDto;

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
