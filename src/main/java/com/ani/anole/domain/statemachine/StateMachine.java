package com.ani.anole.domain.statemachine;

import com.ani.octopus.commons.state.dto.StateMachineDto;
import com.ani.octopus.commons.state.dto.StateNodeDto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zsl on 17-3-6.
 * stateNodes为状态图的数据结构
 * quotas为各个状态节点所在的各个参数类型
 */
public class StateMachine {

    public Integer smId;

    public Set<StateMachineNode> stateNodes;

    public StateMachineNode currentStateNode;

    public StateMachine(Integer smId, Set<StateMachineNode> stateNodes, StateMachineNode stateMachineNode){
        this.smId = smId;
        this.stateNodes = stateNodes;
        this.currentStateNode = stateMachineNode;
    }

    public StateMachineDto toDto(){
        return new StateMachineDto(
                this.smId,
                stateNodesToDto(),
                currentStateNode.toDto()
        );
    }

    private Set<StateNodeDto> stateNodesToDto(){
        if(stateNodes!=null) {
            Set<StateNodeDto> stateNodeDtoSet  = new HashSet<>();
            for (StateMachineNode stateNode : stateNodes) {
                stateNodeDtoSet.add(stateNode.toDto());
            }
            return stateNodeDtoSet;
        }
        return null;
    }
}
