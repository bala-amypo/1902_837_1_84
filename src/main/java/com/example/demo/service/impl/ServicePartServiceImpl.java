package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // <--- This is crucial for Spring to detect it
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
    public Optional<ServicePart> getServicePartById(Long id) {
        return servicePartRepository.findById(id);
    }

    @Override
    public ServicePart updateServicePart(Long id, ServicePart updatedPart) {
        ServicePart existing = servicePartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service Part not found"));
        existing.setName(updatedPart.getName());
        existing.setPrice(updatedPart.getPrice());
        return servicePartRepository.save(existing);
    }

    @Override
    public void deleteServicePart(Long id) {
        servicePartRepository.deleteById(id);
    }
}
