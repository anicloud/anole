package com.ani.anole.repository;

import com.ani.anole.domain.statemachine.StateObject;

/**
 * Created by zsl on 17-3-15.
 */
public interface ObjectStateRepository {
    /**
     * 交由antenna去实现 拉取设备状态
     *
     * @param objectId
     * @return
     */
    StateObject getObjectState(String objectId);

}
