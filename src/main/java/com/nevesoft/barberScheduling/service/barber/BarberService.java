package com.nevesoft.barberScheduling.service.barber;

import com.nevesoft.barberScheduling.model.Barber;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Adalberto Neves
 * @since 15/06/2021
 * @version 1.0
 */
public interface BarberService {

    /**
     *
     * @return list of all Barber
     */
    public List<Barber> findAllBarbers();

    /**
     * Method to find the Barber by the id in the param
     * @param id
     * @return the Barber with the id in @param
     */
    public Barber findBarber(Integer id);

    /**
     * Method to add a new Barber to the database
     * @param request
     * @return null or new Barber inserted into the database
     */
    public Barber addBarber(Barber request);

    /**
     * Method to update with the id in param
     * @param request
     * @return the Barber updated
     */
    public Barber updateBarber(Barber request);

    /**
     * Method to get the Barber with the phone in the param
     * @param request
     * @return the Barber found with the phone int param
     */
    public Barber getBarberByPhone(Barber request);
}
