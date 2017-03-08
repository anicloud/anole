package com.ani.anole.domain.listener;

import com.ani.anole.domain.statemachine.StateMachine;
import com.ani.anole.domain.statemachine.StateMachineEvents;
import com.ani.anole.domain.statemachine.StateObject;

import java.util.List;

/**
 * Created by zsl on 17-3-6.
 */
public interface StateMachineListener {

    /**
     *Object State transfer from StubA to StubB
     * @param event
     * @param stateObject
     */
    public void stateTransfer(StateMachineEvents event, StateObject stateObject);

}
