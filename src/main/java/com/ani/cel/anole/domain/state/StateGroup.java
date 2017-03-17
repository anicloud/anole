package com.ani.cel.anole.domain.state;

import java.util.Set;

/**
 * Created by zsl on 17-3-6.
 */
public class StateGroup {
    public Long groupId;
    public String name;
    public Set<String> tags;

    public StateGroup(Long groupId, String name, Set<String> tags) {
        this.groupId = groupId;
        this.name = name;
        this.tags = tags;
    }
}
