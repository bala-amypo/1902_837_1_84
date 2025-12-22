package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;

    @Autowired
    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry serviceEntry) {
        Vehicle vehicle = serviceEntry.getVehicle();
        if (vehicle == null || !vehicle.isActive()) { // check if vehicle is active
            throw new RuntimeException("Vehicle is inactive or not found");
        }
        return serviceEntryRepository.save(serviceEntry);
    }

    @Override
    public List<ServiceEntry> getAllServiceEntries() {
        return serviceEntryRepository.findAll();
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        Optional<ServiceEntry> optionalEntry = serviceEntryRepository.findById(id);
        return optionalEntry.orElseThrow(() -> new RuntimeException("ServiceEntry not found with id " + id));
    }

    @Override
    public ServiceEntry updateServiceEntry(Long id, ServiceEntry updatedEntry) {
        ServiceEntry existingEntry = getServiceEntryById(id);

        existingEntry.setDescription(updatedEntry.getDescription());
        existingEntry.setDate(updatedEntry.getDate());
        existingEntry.setOdometerReading(updatedEntry.getOdometerReading());
        existingEntry.setVehicle(updatedEntry.getVehicle());

        return serviceEntryRepository.save(existingEntry);
    }

    @Override
    public void deleteServiceEntry(Long id) {
        ServiceEntry existingEntry = getServiceEntryById(id);
        serviceEntryRepository.delete(existingEntry);
    }

    // Custom method example for vehicle entries
    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }
}
