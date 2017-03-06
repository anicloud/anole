package com.ani.anole.domain.construction;

import java.util.List;

/**
 * Created by zsl on 17-3-6.
 * stateGroup的值只和Object的类型相关
 * values数值的类型由quotas确定
 */
public class State {
    public StateGroup stateGroup;
    public Integer stateId;
    public String description;
    public List values;
}
