package com.fourkites.state.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "state", indexes = {@Index(columnList = "state_name", name = "state_name_index")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"state_name"})
})
@Getter
@Setter
@EqualsAndHashCode
public class State implements Serializable {

       private static final long serialVersionUID = -3789306987487120246L;

       @Id
       @GeneratedValue
       @Column(name = "state_id",updatable = false)
       private int stateId;

       @Column(name = "state_name", nullable = false, updatable = false)
       private String stateName;

}
