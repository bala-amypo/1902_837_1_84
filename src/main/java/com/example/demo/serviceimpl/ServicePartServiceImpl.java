package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl {

    @Autowired private ServiceEntryRepository serviceEntryRepository;
    @Autowired private ServicePartRepository servicePartRepository;

    public ServicePart createPart(ServicePart p) {
        if (p.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        serviceEntryRepository.findById(p.getServiceEntry().getId()).orElseThrow();
        return servicePartRepository.save(p);
    }
}
