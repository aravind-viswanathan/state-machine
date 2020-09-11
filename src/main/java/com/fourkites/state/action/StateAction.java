package com.fourkites.state.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fourkites.state.exception.StateException;
import com.fourkites.state.model.State;
import com.fourkites.state.repository.StateRepository;

@Component
public class StateAction {

    @Autowired
    private StateFactory stateFactory;

    public State performAction(String stateName, String action) throws StateException {
        var machine = stateFactory.getState(stateName);
        var state   = machine.handleAction(action);
        return state;
    }
}
