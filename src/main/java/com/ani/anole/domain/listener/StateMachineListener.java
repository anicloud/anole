package com.ani.anole.domain.listener;

import com.ani.anole.domain.core.StateObject;

import java.util.List;

/**
 * Created by zsl on 17-3-6.
 */
public interface StateMachineListener {

    public StateObject getStateObjectByObjectid(String Objectid);

    public List<StateObject> getAllStateObject();
}
