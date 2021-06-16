package com.nevesoft.barberScheduling.repository;

import com.nevesoft.barberScheduling.model.ServicePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePriceRepository extends JpaRepository<ServicePrice, Integer> {
}
