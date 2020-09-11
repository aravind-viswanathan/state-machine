package com.fourkites.state.utils;

import javax.annotation.PostConstruct;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fourkites.state.exception.StateException;
import com.fourkites.state.model.Events;
import com.fourkites.state.model.State;
import com.fourkites.state.model.StateTransition;
import com.fourkites.state.repository.EventRepository;
import com.fourkites.state.repository.StateRepository;
import com.fourkites.state.repository.StateTransitionRepository;

@Component
public class StateUtils {

    private Logger          log = LoggerFactory.getLogger(StateUtils.class);
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private StateTransitionRepository stateTransitionRepository;

    private final Map<String, Map<String, State>> eventTransitionMap = new LinkedHashMap<>();
    private       Map<String, State>              stateMap           = null;

    private List<StateTransition> getAllStateTransitions() {
        return stateTransitionRepository.findAll();
    }

    @PostConstruct
    public void formEventMap() {
        stateMap = getAllStates().stream().collect(Collectors.toMap(State::getStateName, Function.identity()));
        List<StateTransition> transitions = getAllStateTransitions();
        transitions.forEach(s -> {
            String eventCode = s.getEvents().getEventCode();
            String from      = s.getFromState().getStateName();
            String to        = s.getToState().getStateName();

            var fromEventTransition = eventTransitionMap.getOrDefault(from, new HashMap<>());
            fromEventTransition.put(eventCode, stateMap.get(to));
            eventTransitionMap.put(from, fromEventTransition);
        });
        displayTransitionMap();
    }

    public State getNextState(String stateName, String event) {
        return eventTransitionMap.getOrDefault(stateName, new LinkedHashMap<>()).get(event);
    }

    public void displayTransitionMap() {
        StringBuilder buff = new StringBuilder();
        buff.append("----------------------------------------------------------------------------------------------------\n");

        eventTransitionMap.forEach((k, v) -> {
            v.forEach((k1, v1) -> {
                buff.append(String.format("%30s %25s %25s %n", k, k1, v1.getStateName()));
                //buff.append("|").append(k.getStateName()).append("\t\t|").append(k1).append("\t\t|").append(v1.getStateName()).append("\t\t|\n");
            });
        });
        buff.append("----------------------------------------------------------------------------------------------------\n");
        if (log.isInfoEnabled()) {
            log.info("State Machine States and Events\n {}", buff);
        }
    }

    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    public State getStateByStateId(String stateName) throws StateException {
        try {
            return stateRepository.findByStateName(stateName).orElseThrow(() -> new StateException());
        } catch (Exception ex) {
            log.error("Error", ex);
            throw new StateException();
        }

    }

    public boolean validEventForState(String stateName, String eventName) {
        var events = eventTransitionMap.get(stateName);
        return events != null && events.containsKey(eventName);
    }


}
