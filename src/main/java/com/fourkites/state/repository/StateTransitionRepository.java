package com.fourkites.state.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fourkites.state.model.StateTransition;

@Repository
public interface StateTransitionRepository extends JpaRepository<StateTransition, Integer> {

    @Query(value = "select * from event where from_state_id=?", nativeQuery = true)
    List<StateTransition> findEventIdByFromStateId(int fromState);
}
