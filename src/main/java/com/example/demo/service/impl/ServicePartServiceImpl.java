package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository repo;
    private final ServiceEntryRepository entryRepo;

    public ServicePartServiceImpl(ServicePartRepository r,
                                  ServiceEntryRepository e) {
        this.repo = r;
        this.entryRepo = e;
    }

    @Override
    public ServicePart createPart(ServicePart p) {
        if (p.getQuantity() == null || p.getQuantity() <= 0)
            throw new IllegalArgumentException("Quantity must be positive");
        entryRepo.findById(p.getServiceEntry().getId()).orElseThrow();
        return repo.save(p);
    }
}
