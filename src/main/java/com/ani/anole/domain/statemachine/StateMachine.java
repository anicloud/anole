package com.ani.anole.domain.statemachine;

import com.ani.anole.domain.state.State;
import com.ani.octopus.commons.state.dto.StateArgumentDto;
import com.ani.octopus.commons.state.dto.StateDto;
import com.ani.octopus.commons.state.dto.StateMachineDto;
import com.ani.octopus.commons.state.dto.StateNodeDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zsl on 17-3-6.
 * stateNodes为状态图的数据结构
 * quotas为各个状态节点所在的各个参数类型
 */
public class StateMachine implements Serializable {

    public Integer smId;

    public List<StateMachineNode> stateNodes;

    public StateMachineNode currentStateNode;

    public StateMachine(Integer smId, List<StateMachineNode> stateNodes, StateMachineNode stateMachineNode) {
        this.smId = smId;
        this.stateNodes = stateNodes;
        this.currentStateNode = stateMachineNode;
    }

    public StateMachineDto toDto() {
        return new StateMachineDto(
                this.smId,
                toStateDto(currentStateNode)
        );
    }

    private StateDto toStateDto(StateMachineNode stateNode) {
        if (stateNode.state.properties == null)
            return new StateDto(stateNode.state.group.groupId, stateNode.state.stateId);
        List<StateArgumentDto> stateArgumentDtos = new ArrayList<>(stateNode.propsValue.size());
        for (Object arg : stateNode.propsValue) {
            StateArgumentDto stateArgumentDto = new StateArgumentDto(arg);
            stateArgumentDtos.add(stateArgumentDto);
        }
        return new StateDto(stateNode.state.group.groupId, stateNode.state.stateId, stateArgumentDtos);
    }

    private List<StateNodeDto> stateNodesToDto() {
        if (stateNodes != null) {
            List<StateNodeDto> stateNodeDtoSet = new ArrayList<>();
            for (StateMachineNode stateNode : stateNodes) {
                stateNodeDtoSet.add(stateNode.toDto());
            }
            return stateNodeDtoSet;
        }
        return null;
    }
}
