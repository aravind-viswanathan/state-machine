package com.fourkites.state.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fourkites.state.model.Events;

@Repository
public interface EventRepository extends JpaRepository<Events, Integer> {
}
