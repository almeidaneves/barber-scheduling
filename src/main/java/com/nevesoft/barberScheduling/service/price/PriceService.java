package com.nevesoft.barberScheduling.service.price;

import com.nevesoft.barberScheduling.model.ServicePrice;

import java.util.List;

/**
 * @author Adalberto Neves
 * @since 17/06/2021
 * @version 1.0
 */
public interface PriceService {
    /**
     *
     * @return list of all ServicePrice
     */
    public List<ServicePrice> findAllServicePrices();

    /**
     * Method to find the ServicePrice by the id in the param
     * @param id
     * @return the ServicePrice with the id in @param
     */
    public ServicePrice findServicePrice(Integer id);

    /**
     * Method to add a new ServicePrice to the database
     * @param request
     * @return null or new ServicePrice inserted into the database
     */
    public ServicePrice addServicePrice(ServicePrice request);

    /**
     * Method to update with the id in param
     * @param request
     * @return the ServicePrice updated
     */
    public ServicePrice updateServicePrice(ServicePrice request);

    /**
     * Method to get the ServicePrice with the phone in the param
     * @param request
     * @return the ServicePrice found with the phone int param
     */
    public ServicePrice getServicePriceByName(ServicePrice request);
}
