package com.nevesoft.barberScheduling.controller;

import com.nevesoft.barberScheduling.exception.SchedulingRespose;
import com.nevesoft.barberScheduling.model.Barber;
import com.nevesoft.barberScheduling.repository.BarberRepository;
import com.nevesoft.barberScheduling.service.barber.BarberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/")
public class BarberController {

    public static final Logger LOGGER = LoggerFactory.getLogger("BarberController.class");
    @Autowired
    private BarberService barberService;
    @Autowired
    private BarberRepository barberRepository;

    @GetMapping("barbers")
    public ResponseEntity<List<Barber>> getAllBarbers(){

        List<Barber> barberList = barberService.findAllBarbers();

        if(barberList.isEmpty()){
            LOGGER.trace("BarberList is empty...");
            return new ResponseEntity<>(barberList, HttpStatus.NOT_FOUND);
        }
        LOGGER.info("List of Barber..");
        return new ResponseEntity<>(barberList, HttpStatus.OK);
    }
    @PostMapping("barbers/add")
    public ResponseEntity<?> addBarber(@Valid @RequestBody Barber request){

        Optional<Barber> existBarber = barberRepository.findByEmail(request.getEmail());
        Optional<Barber> existBarberbyPhone = barberRepository.findByPhone(request.getPhone());

        if(existBarber.isPresent()) {

            return  new ResponseEntity<>(new SchedulingRespose("Invalid data! Email already exist",409 ),HttpStatus.CONFLICT);
        }
        else if(existBarberbyPhone.isPresent()){
            return  new ResponseEntity<>(new SchedulingRespose("Invalid data! Phone already exist",409 ),HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(barberService.addBarber(request), HttpStatus.CREATED);
    }
    @GetMapping("barbers/{id}")
    public ResponseEntity<?> getBarber(@PathVariable("id") Integer id){
        Barber barber = barberService.findBarber(id);

        if(barber == null)
            return new ResponseEntity<>(new SchedulingRespose("Barber with id "+id+" not found", 404), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(barber, HttpStatus.OK);

    }

    @PutMapping("barbers/update")
    public ResponseEntity<?> updateBarber(@RequestBody Barber request){
        //Barber barber = barberService.findBarber(request.getId());
        if (request.getId()==null){
            return  new ResponseEntity<>(new SchedulingRespose("Id must not be null ", 404), HttpStatus.NOT_FOUND);
        }
        else if(!barberRepository.existsById(request.getId())){
            return  new ResponseEntity<>(new SchedulingRespose("Barber with this id not found", 404), HttpStatus.NOT_FOUND);
        }
        request = barberService.updateBarber(request);

        return new ResponseEntity<>(barberService.updateBarber(request), HttpStatus.CREATED);
    }
    @DeleteMapping("barbers/delete/{id}")
    public ResponseEntity<?> deleteBarber(@PathVariable("id") Integer id){

        if(!barberRepository.existsById(id))
            return  new ResponseEntity<>(new SchedulingRespose("Barber with this id not found",404), HttpStatus.NOT_FOUND);
        barberRepository.deleteById(id);

        return new ResponseEntity<>(new SchedulingRespose("Barber with this id: "+id+" was deleted with success..",200),HttpStatus.NO_CONTENT);
    }
}
