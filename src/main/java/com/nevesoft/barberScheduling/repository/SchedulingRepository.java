package com.nevesoft.barberScheduling.repository;

import com.nevesoft.barberScheduling.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {
}
