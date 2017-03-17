package com.ani.cel.anole.domain.listener;

import com.ani.cel.anole.domain.statemachine.StateObject;

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
