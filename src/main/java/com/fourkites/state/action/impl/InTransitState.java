package com.fourkites.state.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fourkites.state.exception.StateException;
import com.fourkites.state.utils.StateUtils;

@Component("IN_TRANSIT")
public class InTransitState extends StateMachineImpl {

    private Logger LOG = LoggerFactory.getLogger(InTransitState.class);

    @Autowired
    private StateUtils stateUtils;

    @Override
    public String getStateId() throws StateException {
        return "IN_TRANSIT";
    }

}

