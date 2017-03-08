package com.ani.anole.domain.statemachine;

import com.ani.octopus.commons.stub.dto.StubDto;

/**
 * Created by zsl on 17-3-7.
 */
public class StateTransferStubInvokeTrigger extends StateTransferTrigger {

    public StateTransferStubInvokeTrigger() {
    }

    @Override
    public StateMachineEvents checkStateTransfer() {
        //TODO
        return null;
    }

    public StateTransferStubInvokeTrigger(StubDto stub) {
        this.stub = stub;
    }

    public StateTransferStubInvokeTrigger(StateMachineNode nextStateMachineNode, StubDto stub) {
        super(nextStateMachineNode);
        this.stub = stub;
    }

    public StubDto stub;

}
