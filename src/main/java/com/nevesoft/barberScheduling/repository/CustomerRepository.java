package com.nevesoft.barberScheduling.repository;

import com.nevesoft.barberScheduling.model.Barber;
import com.nevesoft.barberScheduling.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

     public Optional<Customer> findByPhone(String phone);
     public Optional<Customer> findByEmail(String email);
}
