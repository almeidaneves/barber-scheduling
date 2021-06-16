package com.nevesoft.barberScheduling.service;

import com.nevesoft.barberScheduling.exception.BarberSchedulingRespose;
import com.nevesoft.barberScheduling.model.Barber;
import com.nevesoft.barberScheduling.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarberServiceImpl implements BarberService{

    @Autowired
    private BarberRepository barberRepository;

    @Override
    public List<Barber> findAllBarbers() {
        return barberRepository.findAll();
    }

    @Override
    public Barber findBarber(Integer id) {
        //Optional<Barber> optionalBarber = barberRepository.findById(id).orElse;
        //Barber barber = optionalBarber.get();
        return barberRepository.findById(id).orElse(null);
    }

    @Override
    public Barber addBarber(Barber request) {
        return barberRepository.save(request);
    }

    @Override
    public Barber updateBarber(Barber request) {
        return barberRepository.save(request);
    }

    @Override
    public Barber getBarberByPhone(Barber request) {
        return barberRepository.findByPhone(request.getPhone);
    }
}
