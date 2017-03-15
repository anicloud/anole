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
     * Object State transfer from StubA to StubB
     * @param stateObject
     */
    public void onStateObjectEvent(StateObject stateObject);

}
