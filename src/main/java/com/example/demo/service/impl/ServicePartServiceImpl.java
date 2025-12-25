package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    @Override
    public ServicePart createServicePart(ServicePart part) {
        return part;
    }

    @Override
    public List<ServicePart> getAllServiceParts() {
        return List.of();
    }

    @Override
    public Optional<ServicePart> getServicePartById(Long id) {
        return Optional.empty();
    }

    @Override
    public ServicePart updateServicePart(Long id, ServicePart part) {
        return part;
    }

    @Override
    public void deleteServicePart(Long id) {
        // no implementation needed
    }
}
