package com.ani.anole.service;


import com.ani.anole.domain.statemachine.StateObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by zsl on 17-3-7.
 */
@Component
public class StateMachineServiceImp implements StateMachineService {

    @Resource
    private StateMachineObjectManager stateMachineObjectManager;

    @Override
    public StateObject getStateObject(String objectId) {
        return stateMachineObjectManager.findStateObject(objectId);
    }

}
