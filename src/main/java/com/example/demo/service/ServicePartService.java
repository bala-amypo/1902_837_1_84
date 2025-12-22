package com.example.demo.service;

import com.example.demo.model.ServicePart;

import java.util.List;
import java.util.Optional;

public interface ServicePartService {
    ServicePart createServicePart(ServicePart part);
    List<ServicePart> getAllServiceParts();
    Optional<ServicePart> getServicePartById(Long id);
    ServicePart updateServicePart(Long id, ServicePart part);
    void deleteServicePart(Long id);
}
