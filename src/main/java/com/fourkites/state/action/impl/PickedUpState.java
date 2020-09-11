package com.fourkites.state.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fourkites.state.exception.StateException;

@Component("PICKED_UP")
public class PickedUpState extends StateMachineImpl {

    private Logger     LOG = LoggerFactory.getLogger(PickedUpState.class);

    @Override
    public String getStateId() throws StateException {
        return "PICKED_UP";
    }
}
