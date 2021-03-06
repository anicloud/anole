package com.ani.anole.domain.state;

import com.ani.octopus.commons.state.dto.StateDto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zsl on 17-3-6.
 * stateGroup的值只和Object的类型相关
 * values数值的类型由quotas确定
 */
public class State implements Serializable {

    private static final long serialVersionUID = 1941995874906991261L;

    public StateGroup group;

    public Integer stateId;

    public String description;

    public List<StateProperty> properties;

    public State() {

    }

    public State(Long stateGroupId, Integer stateId) {
        this.group = new StateGroup(stateGroupId);
        this.stateId = stateId;
    }

    public State(StateGroup group, Integer stateId, String description, List<StateProperty> properties) {
        this.group = group;
        this.stateId = stateId;
        this.description = description;
        this.properties = properties;

    }


    @Override
    public int hashCode() {
        if (!isLegal()) return 0;
        return this.group.groupId.intValue() + this.stateId;
    }

    @Override
    public boolean equals(Object obj) {
        State cmpState = (State) obj;
        if (!this.isLegal()
                && cmpState != null
                && cmpState.stateId != null)
            return (this.stateId == cmpState.stateId)
                    && (this.group.groupId == cmpState.group.groupId);
        else
            return false;
    }

    public boolean isLegal() {
        if (this == null
                || this.stateId == null
                || this.group == null
                || this.group.groupId == null)
            return false;
        else
            return true;
    }

    public StateDto toDto() {
        return new StateDto(this.group.groupId, this.stateId);
    }
}
