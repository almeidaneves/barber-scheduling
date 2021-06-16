package com.nevesoft.barberScheduling.controller;

import com.nevesoft.barberScheduling.exception.BarberSchedulingRespose;
import com.nevesoft.barberScheduling.model.Barber;
import com.nevesoft.barberScheduling.repository.BarberRepository;
import com.nevesoft.barberScheduling.service.BarberService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/api/")
public class BarberController {
    @Autowired
    private BarberService barberService;
    @Autowired
    private BarberRepository barberRepository;
    public static final Logger logger = (Logger) LoggerFactory.getLogger(BarberController.class);

    @GetMapping("barbers")
    public ResponseEntity<List<Barber>> getAllBarbers(){
        List<Barber> barberList = barberService.findAllBarbers();

        if(barberList.isEmpty()){
            return new ResponseEntity<>(barberList, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(barberList, HttpStatus.OK);
    }
    @PostMapping("barbers/add")
    public ResponseEntity<?> addBarber(@Valid @RequestBody Barber request){

        Optional<Barber> existBarber = barberRepository.findByEmail(request.getEmail());
        Optional<Barber> existBarberbyPhone = barberRepository.findByPhone(request.getPhone());

        if(existBarber.isPresent()) {

            return  new ResponseEntity<>(new BarberSchedulingRespose("Invalid data! Email already exist",409 ),HttpStatus.CONFLICT);
        }
        else if(existBarberbyPhone.isPresent()){
            return  new ResponseEntity<>(new BarberSchedulingRespose("Invalid data! Phone already exist",409 ),HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(barberService.addBarber(request), HttpStatus.CREATED);
    }
    @GetMapping("barbers/{id}")
    public ResponseEntity<?> getBarber(@PathVariable("id") Integer id){
        Barber barber = barberService.findBarber(id);

        if(barber == null)
            return new ResponseEntity<>(new BarberSchedulingRespose("Barber with id "+id+" not found", 404), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(barber, HttpStatus.OK);

    }

    @PutMapping("barbers/update")
    public ResponseEntity<?> updateBarber(@RequestBody Barber request){
        //Barber barber = barberService.findBarber(request.getId());

        if(!barberRepository.existsById(request.getId())){
            return  new ResponseEntity<>(new BarberSchedulingRespose("Barber with this id not found", 404), HttpStatus.NOT_FOUND);
        }
        request = barberService.updateBarber(request);

        return new ResponseEntity<>(barberService.updateBarber(request), HttpStatus.CREATED);
    }
    @DeleteMapping("barbers/delete/{id}")
    public ResponseEntity<?> deleteBarber(@PathVariable("id") Integer id){

        if(!barberRepository.existsById(id))
            return  new ResponseEntity<>(new BarberSchedulingRespose("Barber with this id not found",404), HttpStatus.NOT_FOUND);
        barberRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
