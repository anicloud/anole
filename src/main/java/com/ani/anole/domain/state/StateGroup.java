package com.ani.anole.domain.state;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by zsl on 17-3-6.
 */
public class StateGroup implements Serializable {

    private static final long serialVersionUID = 2729495707957440859L;
    public Long groupId;

    public String name;

    public Set<String> tags;

    public StateGroup() {

    }

    public StateGroup(Long groupId) {
        this.groupId = groupId;
    }

    public StateGroup(Long groupId, String name, Set<String> tags) {
        this.groupId = groupId;
        this.name = name;
        this.tags = tags;
    }

}
