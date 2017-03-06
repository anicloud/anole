package com.ani.anole.domain.core;

import com.ani.anole.domain.construction.State;

import java.util.Set;

/**
 * Created by zsl on 17-3-6.
 */
public class StateObject {
    public Set<StateMachine> stateMachines;
    public Set<State> states;
    public String objectId;

    public static boolean checkStateObject(StateObject stateObject) {

        if (stateObject == null) return false;
        if (stateObject.states.size() != stateObject.stateMachines.size())
            //TODO 检验states中state里的values和stateMachine里quotas一一对应
            return false;

        return false;
    }
}
