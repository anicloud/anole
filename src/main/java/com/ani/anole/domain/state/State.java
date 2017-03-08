package com.ani.anole.domain.state;

import java.util.List;

/**
 * Created by zsl on 17-3-6.
 * stateGroup的值只和Object的类型相关
 * values数值的类型由quotas确定
 */
public class State {
    public StateGroup group;
    public Integer stateId;
    public String description;
    public List<StateProperty> properties;

    public State(StateGroup group, Integer stateId, String description, List<StateProperty> properties) {
        this.group = group;
        this.stateId = stateId;
        this.description = description;
        this.properties = properties;

    }
}
