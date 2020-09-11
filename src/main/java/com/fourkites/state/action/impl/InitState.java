package com.fourkites.state.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fourkites.state.exception.StateException;

@Component("INITSTATE")
public class InitState extends StateMachineImpl {

    private Logger LOG = LoggerFactory.getLogger(InitState.class);

    @Override
    public String getStateId() throws StateException {
        return "INITSTATE";
    }
}
