package com.nevesoft.barberScheduling.service.price;

import com.nevesoft.barberScheduling.model.ServicePrice;
import com.nevesoft.barberScheduling.repository.ServicePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceServiceImpl implements PriceService{
    @Autowired
    private ServicePriceRepository servicePriceRepository;

    @Override
    public List<ServicePrice> findAllServicePrices() {
        return servicePriceRepository.findAll();
    }

    @Override
    public ServicePrice findServicePrice(Integer id) {
        return servicePriceRepository.findById(id).orElse(null);
    }

    @Override
    public ServicePrice addServicePrice(ServicePrice request) {
        return servicePriceRepository.save(request);
    }

    @Override
    public ServicePrice updateServicePrice(ServicePrice request) {
        return servicePriceRepository.save(request);
    }

    @Override
    public ServicePrice getServicePriceByName(ServicePrice request) {
        return servicePriceRepository.findByName(request.getName()).orElse(null);
    }
}
