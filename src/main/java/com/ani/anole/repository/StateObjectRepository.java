package com.ani.anole.repository;

import com.ani.anole.domain.statemachine.StateObject;
import org.springframework.stereotype.Service;

/**
 * Created by zsl on 17-3-15.
 */
@Service
public interface StateObjectRepository {
    /**
     * 存入redis 缓存
     *
     * @return
     */
    public StateObject getStateObject(String stateObjectId);

    public void putStateObject(String stateObjectId,StateObject stateObject);

    void putIfAbsent(String stateObjectId, StateObject stateObject);

    public void delStateObject(String stateObjectId);
}
