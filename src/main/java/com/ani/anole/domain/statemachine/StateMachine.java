package com.ani.anole.domain.statemachine;

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

}
