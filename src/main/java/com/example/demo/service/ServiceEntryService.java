package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry entry);

    ServiceEntry getServiceEntryById(Long id);

    List<ServiceEntry> getEntriesForVehicle(long vehicleId);

    List<ServiceEntry> getAllServiceEntries();

    ServiceEntry updateServiceEntry(Long id, ServiceEntry entry);

    void deleteServiceEntry(Long id);
}
