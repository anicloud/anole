package com.ani.anole.domain.statemachine;

import com.ani.anole.domain.state.State;
import com.ani.utils.exception.AniRuleException;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.util.Collection;
import java.util.List;

/**
 * Created by zsl on 17-3-6.
 */
public class StateMachineNode {

    public State state;

    public List propValues;

    public Collection<StateTransferTrigger> stateTransferTriggers;

    public StateMachineNode(State state, List propValues, Collection<StateTransferTrigger> stateTransferTriggers) {
        this.state = state;
        this.propValues = propValues;
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
                || cmpNode == null
                || cmpNode.state.isLegal())
            return true;
        else
            return false;
    }
}
