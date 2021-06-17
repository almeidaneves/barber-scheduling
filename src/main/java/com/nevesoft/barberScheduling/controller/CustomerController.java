package com.nevesoft.barberScheduling.controller;

import com.nevesoft.barberScheduling.exception.SchedulingRespose;
import com.nevesoft.barberScheduling.model.Customer;
import com.nevesoft.barberScheduling.repository.CustomerRepository;
import com.nevesoft.barberScheduling.service.customer.CustomerService;
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
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    //public static final Logger logger = (Logger) LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> CustomerList = customerService.findAllCustomers();

        if(CustomerList.isEmpty()){
            return new ResponseEntity<>(CustomerList, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(CustomerList, HttpStatus.OK);
    }
    @PostMapping("customers/add")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer request){

        Optional<Customer> existCustomer = customerRepository.findByEmail(request.getEmail());
        Optional<Customer> existCustomerbyPhone = customerRepository.findByPhone(request.getPhone());

        if(existCustomer.isPresent()) {

            return  new ResponseEntity<>(new SchedulingRespose("Invalid data! Email already exist",409 ),HttpStatus.CONFLICT);
        }
        else if(existCustomerbyPhone.isPresent()){
            return  new ResponseEntity<>(new SchedulingRespose("Invalid data! Phone already exist",409 ),HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(customerService.addCustomer(request), HttpStatus.CREATED);
    }
    @GetMapping("customers/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable("id") Integer id){
        Customer Customer = customerService.findCustomer(id);

        if(Customer == null)
            return new ResponseEntity<>(new SchedulingRespose("Customer with id "+id+" not found", 404), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Customer, HttpStatus.OK);

    }

    @PutMapping("customers/update")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer request){
        //Customer Customer = CustomerService.findCustomer(request.getId());

        if (request.getId()==null){
            return  new ResponseEntity<>(new SchedulingRespose("Id must not be null ", 404), HttpStatus.NOT_FOUND);
        }
        else if(!customerRepository.existsById(request.getId())){
            return  new ResponseEntity<>(new SchedulingRespose("Customer with this id not found", 404), HttpStatus.NOT_FOUND);
        }
        request = customerService.updateCustomer(request);

        return new ResponseEntity<>(customerService.updateCustomer(request), HttpStatus.CREATED);
    }
    @DeleteMapping("customers/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id){

        if(!customerRepository.existsById(id))
            return  new ResponseEntity<>(new SchedulingRespose("Customer with this id not found",404), HttpStatus.NOT_FOUND);
        customerRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
