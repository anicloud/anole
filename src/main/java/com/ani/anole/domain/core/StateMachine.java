package com.ani.anole.domain.core;

import com.ani.anole.domain.construction.Quota;
import com.ani.anole.domain.construction.StateNode;

import java.util.List;
import java.util.Set;

/**
 * Created by zsl on 17-3-6.
 * stateNodes为状态图的数据结构
 * quotas为各个状态节点所在的各个参数类型
 */
public class StateMachine {
    public Long machineId;
    public Set<StateNode> stateNodes;
    public List<Quota> quotas;

    @Override
    public int hashCode() {
        return machineId.hashCode();
    }
}
