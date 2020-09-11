package com.fourkites.state.action;

import com.fourkites.state.model.State;

public interface StateFactory {
    StateMachine getState(String action);

}
