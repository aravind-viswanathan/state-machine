package com.fourkites.state.action;

import com.fourkites.state.exception.StateException;
import com.fourkites.state.model.State;

public interface StateMachine {
    State handleAction(String event) throws StateException;

    String getStateId() throws StateException;

    State getNextState(String event) throws StateException;
}
