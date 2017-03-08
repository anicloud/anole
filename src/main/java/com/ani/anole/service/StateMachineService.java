package com.ani.anole.service;

import com.ani.anole.domain.statemachine.StateObject;
import com.ani.anole.domain.statemachine.StateTransferTrigger;

import javax.annotation.Resource;

/**
 * Created by zsl on 17-3-6.
 * 此接口供用户调用查询
 */
@Resource
public interface StateMachineService {

    public StateObject getStateObject(String objectId);

//     public boolean checkInvokeEvent(String objectId, Integer machineId, StateTransferTrigger stateTransferTrigger); TODO
}
