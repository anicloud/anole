package com.ani.anole.domain.statemachine;

import com.ani.anole.domain.state.State;
import com.ani.octopus.commons.state.dto.StateNodeDto;
import com.ani.utils.exception.AniRuleException;

import java.util.Collection;
import java.util.List;

/**
 * Created by zsl on 17-3-6.
 */
public class StateMachineNode {

    public State state;

    public List propsValue;

    public Collection<StateTransferTrigger> stateTransferTriggers;

    public StateMachineNode(State state, List propsValue, Collection<StateTransferTrigger> stateTransferTriggers) {
        this.state = state;
        this.propsValue = propsValue;
        this.stateTransferTriggers = stateTransferTriggers;
    }

    public static boolean checkValuesType(State state, List propValues) throws AniRuleException {
        //todo
        return false;
    }

    @Override
    public int hashCode() {
        return this.state.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        StateMachineNode cmpNode = (StateMachineNode) obj;
        if (!this.state.isLegal()
                && cmpNode != null)
            return this.state.equals(cmpNode.state);
        else
            return false;
    }
    public StateNodeDto toDto(){
        return new StateNodeDto(this.state.toDto(),propsValue);
    }
}
