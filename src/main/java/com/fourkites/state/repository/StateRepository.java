package com.fourkites.state.repository;

import javax.print.attribute.IntegerSyntax;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fourkites.state.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, IntegerSyntax> {

    Optional<State> findByStateName(String stateName);
}
