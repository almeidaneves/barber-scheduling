package com.nevesoft.barberScheduling.repository;

import com.nevesoft.barberScheduling.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Integer> {

    public Optional <Barber> findByEmail(String email);
    public Optional <Barber> findByPhone(String phone);
}
