package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        return entry;
    }

    @Override
    public List<ServiceEntry> getAllServiceEntries() {
        return List.of();
    }

    @Override
    public Optional<ServiceEntry> getServiceEntryById(Long id) {
        return Optional.empty();
    }

    @Override
    public ServiceEntry updateServiceEntry(Long id, ServiceEntry entry) {
        return entry;
    }

    @Override
    public void deleteServiceEntry(Long id) {
        // no implementation needed
    }
}
