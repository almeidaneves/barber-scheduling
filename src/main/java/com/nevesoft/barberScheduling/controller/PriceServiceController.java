package com.nevesoft.barberScheduling.controller;

import com.nevesoft.barberScheduling.exception.SchedulingRespose;
import com.nevesoft.barberScheduling.model.ServicePrice;
import com.nevesoft.barberScheduling.repository.ServicePriceRepository;
import com.nevesoft.barberScheduling.service.price.PriceService;
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
public class PriceServiceController {
    @Autowired
    private PriceService priceService;
    @Autowired
    private ServicePriceRepository servicePriceRepository;
    //public static final Logger logger = (Logger) LoggerFactory.getLogger(ServicePriceController.class);

    @GetMapping("servicePrices")
    public ResponseEntity<List<ServicePrice>> getAllServicePrices(){
        List<ServicePrice> ServicePriceList = priceService.findAllServicePrices();

        if(ServicePriceList.isEmpty()){
            return new ResponseEntity<>(ServicePriceList, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ServicePriceList, HttpStatus.OK);
    }
    @PostMapping("servicePrices/add")
    public ResponseEntity<?> addServicePrice(@Valid @RequestBody ServicePrice request){

        ServicePrice servicePrice = priceService.addServicePrice(request);

        if(servicePrice == null) {
            return  new ResponseEntity<>(new SchedulingRespose("Invalid data! Email already exist",409 ),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(servicePrice, HttpStatus.CREATED);
    }
    @GetMapping("servicePrices/{id}")
    public ResponseEntity<?> getServicePrice(@PathVariable("id") Integer id){
        ServicePrice ServicePrice = priceService.findServicePrice(id);

        if(ServicePrice == null)
            return new ResponseEntity<>(new SchedulingRespose("ServicePrice with id "+id+" not found", 404), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ServicePrice, HttpStatus.OK);

    }

    @PutMapping("servicePrices/update")
    public ResponseEntity<?> updateServicePrice(@RequestBody ServicePrice request){
        //ServicePrice ServicePrice = ServicePriceService.findServicePrice(request.getId());

        if(!servicePriceRepository.existsById(request.getId())){
            return  new ResponseEntity<>(new SchedulingRespose("ServicePrice with this id not found", 404), HttpStatus.NOT_FOUND);
        }
        request = priceService.updateServicePrice(request);

        return new ResponseEntity<>(priceService.updateServicePrice(request), HttpStatus.CREATED);
    }
    @DeleteMapping("servicePrices/delete/{id}")
    public ResponseEntity<?> deleteServicePrice(@PathVariable("id") Integer id){

        if(!servicePriceRepository.existsById(id))
            return  new ResponseEntity<>(new SchedulingRespose("ServicePrice with this id not found",404), HttpStatus.NOT_FOUND);
        servicePriceRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
