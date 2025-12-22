package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry serviceEntry) {
        return serviceEntryRepository.save(serviceEntry);
    }

    @Override
    public List<ServiceEntry> getAllServiceEntries() {
        return serviceEntryRepository.findAll();
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        return serviceEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceEntry not found with id " + id));
    }

    @Override
    public ServiceEntry updateServiceEntry(Long id, ServiceEntry updatedEntry) {
        ServiceEntry entry = getServiceEntryById(id);
        entry.setDescription(updatedEntry.getDescription());
        entry.setDate(updatedEntry.getDate());
        entry.setOdometerReading(updatedEntry.getOdometerReading());
        return serviceEntryRepository.save(entry);
    }

    @Override
    public void deleteServiceEntry(Long id) {
        serviceEntryRepository.deleteById(id);
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }
}
