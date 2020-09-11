package com.fourkites.state.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "events", indexes = {@Index(columnList = "event_code", name = "event_code_index")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"event_code"}), @UniqueConstraint(columnNames = {"event_code"})
})
@Getter
@Setter
@EqualsAndHashCode
public class Events implements Serializable {

    private static final long serialVersionUID = 7212253169249138783L;

    @Id
    @GeneratedValue
    @Column(name = "event_id", updatable = false)
    private int id;

    @Column(name = "event_code", nullable = false, updatable = false)
    private String eventCode;

    @Column(name = "event_desc", nullable = false, updatable = false)
    private String eventDesc;
}
