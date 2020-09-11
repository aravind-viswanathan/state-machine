package com.fourkites.state.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fourkites.state.action.StateMachine;
import com.fourkites.state.exception.StateException;
import com.fourkites.state.model.State;
import com.fourkites.state.utils.StateUtils;

public abstract class StateMachineImpl implements StateMachine {

    private Logger LOG = LoggerFactory.getLogger(StateMachineImpl.class);

    @Autowired
    private StateUtils stateUtils;

    @Override
    public State getNextState(String event) throws StateException {
        State state = stateUtils.getNextState(getStateId(), event);
        LOG.info("Moving from {} to {}", getStateId(), state.getStateName());
        return state;
    }

    @Override
    public State handleAction(String event) throws StateException {
        if (stateUtils.validEventForState(getStateId(), event)) {
            LOG.info("Handling event {} for state {}", event, getStateId());
            var state =  getNextState(event);
            return state;
        } else {
            LOG.error("Invalid state for InitState");
            throw new StateException();
        }
    }
}
