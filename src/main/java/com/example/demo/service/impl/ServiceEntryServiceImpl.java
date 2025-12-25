package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ServiceEntry getServiceEntryById(Long id) {
        return null;   // interface expects ServiceEntry, NOT Optional
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return List.of();   // ✅ missing method added
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
