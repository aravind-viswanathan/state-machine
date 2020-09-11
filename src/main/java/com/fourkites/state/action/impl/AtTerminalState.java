package com.fourkites.state.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fourkites.state.exception.StateException;

@Component("AT_TERMINAL")
public class AtTerminalState extends StateMachineImpl {

    private Logger LOG = LoggerFactory.getLogger(AtTerminalState.class);

    @Override
    public String getStateId() throws StateException {
        return "AT_TERMINAL";

    }

}