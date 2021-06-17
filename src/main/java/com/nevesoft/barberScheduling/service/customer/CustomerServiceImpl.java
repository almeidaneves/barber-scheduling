package com.nevesoft.barberScheduling.service.customer;

import com.nevesoft.barberScheduling.model.Customer;
import com.nevesoft.barberScheduling.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomer(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer addCustomer(Customer request) {
        return customerRepository.save(request);
    }

    @Override
    public Customer updateCustomer(Customer request) {
        return customerRepository.save(request);
    }

    @Override
    public Customer getCustomerByPhone(Customer request) {
        return customerRepository.findByPhone(request.getPhone()).orElse(null);
    }
}
