package com.fourkites.state.action.impl;

import org.springframework.stereotype.Component;

import com.fourkites.state.exception.StateException;

@Component("OUT_FOR_DELIVERY")
public class OutForDeliveryState extends StateMachineImpl {

    @Override
    public String getStateId() throws StateException {
        return "OUT_FOR_DELIVERY";
    }
}
