package com.ani.statusmachine.core;

import java.util.Collection;
import java.util.Map;

/**
 * Created by zsl on 17-2-28.
 * this class is about state-transition-diagram
 * StatusA-Stub1 is consisted of the key of Map  ,the value of Map is StubB which Object can excute Stub1 from StatusA to.
 *
 * 发布/订阅模式 devicebus - sunny
 * 观察者模式  device - anole
 */
public class StatusGroup {
    public Integer statusgroupid;
    public Collection<Map> statusmap;

    public StatusGroup(int statusgroupid, Collection<Map> statusmap) {
        this.statusgroupid = statusgroupid;
        this.statusmap = statusmap;
    }
}
