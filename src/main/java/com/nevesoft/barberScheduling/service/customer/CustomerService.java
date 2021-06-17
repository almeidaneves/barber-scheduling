package com.nevesoft.barberScheduling.service.customer;

import com.nevesoft.barberScheduling.model.Customer;

import java.util.List;
/**
 * @author Adalberto Neves
 * @since 17/06/2021
 * @version 1.0
 */
public interface CustomerService {
    /**
     *
     * @return list of all Customer
     */
    public List<Customer> findAllCustomers();

    /**
     * Method to find the Customer by the id in the param
     * @param id
     * @return the Customer with the id in @param
     */
    public Customer findCustomer(Integer id);

    /**
     * Method to add a new Customer to the database
     * @param request
     * @return null or new Customer inserted into the database
     */
    public Customer addCustomer(Customer request);

    /**
     * Method to update with the id in param
     * @param request
     * @return the Customer updated
     */
    public Customer updateCustomer(Customer request);

    /**
     * Method to get the Customer with the phone in the param
     * @param request
     * @return the Customer found with the phone int param
     */
    public Customer getCustomerByPhone(Customer request);
}
