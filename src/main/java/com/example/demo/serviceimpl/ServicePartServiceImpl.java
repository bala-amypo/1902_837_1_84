package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository servicePartRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository) {
        this.servicePartRepository = servicePartRepository;
    }

    @Override
    public ServicePart createServicePart(ServicePart part) {
        return servicePartRepository.save(part);
    }

    @Override
    public List<ServicePart> getAllServiceParts() {
        return servicePartRepository.findAll();
    }

    @Override
    public ServicePart getServicePartById(Long id) {
        return servicePartRepository.findById(id).orElse(null);
    }

    @Override
    public ServicePart updateServicePart(Long id, ServicePart part) {
        part.setId(id);
        return servicePartRepository.save(part);
    }

    @Override
    public void deleteServicePart(Long id) {
        servicePartRepository.deleteById(id);
    }
}
