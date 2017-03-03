package com.ani.statusmachine.core;

import java.util.Collection;
import java.util.Map;

/**
 * Created by zsl on 17-2-28.
 * Objectid is the unique id of object ,number is object's slave ,so they two can confirm the only machine
 */
public class StatusMachine {
    public String objectid;
    public Integer number;
    public Integer statusGroup;
    public volatile Integer status;
    public Collection<Map> parameters;
}
