package com.ani.anole.service;

import com.ani.anole.domain.core.StateObject;

/**
 * Created by zsl on 17-3-6.
 * 此接口供用户调用查询
 */
public interface StateMachineService {
    public StateObject getStateByObjectId();

}
