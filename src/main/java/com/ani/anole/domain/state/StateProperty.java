package com.ani.anole.domain.state;


import com.ani.utils.core.datatype.AniDataType;

/**
 * Created by zsl on 17-3-6.
 * 参数的数据类型以及相关描述
 */
public class StateProperty {

    public AniDataType dataType;

    public String name;

    public StateProperty(AniDataType dataType, String name) {
        this.dataType = dataType;
        this.name = name;
    }
}
