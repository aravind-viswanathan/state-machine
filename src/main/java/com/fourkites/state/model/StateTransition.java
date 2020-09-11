package com.fourkites.state.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "state_transition")
@Getter
@Setter
@EqualsAndHashCode
public class StateTransition implements Serializable {

    private static final long serialVersionUID = -4821173894227552563L;

    @Id
    @GeneratedValue
    @Column(name = "st_id", nullable = false)
    private int id;

    @JoinColumn(name = "st_from_state_id", updatable = false)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private State fromState;

    @JoinColumn(name = "st_to_state_id", updatable = false)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private State toState;

    @JoinColumn(name="st_event_id", updatable = false)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Events events;

}
