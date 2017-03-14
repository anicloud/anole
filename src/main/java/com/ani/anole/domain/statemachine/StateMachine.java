package com.ani.anole.domain.statemachine;

import com.ani.anole.domain.listener.StateMachineListener;

import java.util.Set;
import java.util.Vector;

/**
 * Created by zsl on 17-3-6.
 * stateNodes为状态图的数据结构
 * quotas为各个状态节点所在的各个参数类型
 */
public class StateMachine {

    public Integer machineId;

    public Set<StateMachineNode> stateMachineNodes;


    public StateMachineNode currentStateNode;
    public StateMachine(Integer machineId,Set<StateMachineNode>stateMachineNodes,StateMachineNode stateMachineNode){
        this.machineId =machineId;
        this.stateMachineNodes = stateMachineNodes;
        this.currentStateNode = stateMachineNode;
    }


}
