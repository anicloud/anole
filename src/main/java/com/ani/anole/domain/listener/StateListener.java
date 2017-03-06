package com.ani.anole.domain.listener;

import com.ani.anole.domain.core.StateObjectDto;

/**
 * Created by zsl on 17-3-6.
 */
public interface StateListener {
    public StateObjectDto getStateObjectByObjectid(String Objectid);
}
