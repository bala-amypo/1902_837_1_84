package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

    public ServiceEntryServiceImpl(
            ServiceEntryRepository serviceEntryRepository,
            VehicleRepository vehicleRepository,
            GarageRepository garageRepository
    ) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        if (!Boolean.TRUE.equals(vehicle.getActive())) {
            throw new IllegalArgumentException("Service allowed only for active vehicles");
        }

        Garage garage = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        if (!Boolean.TRUE.equals(garage.getActive())) {
            throw new IllegalArgumentException("Garage is inactive");
        }

        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Service date cannot be in the future");
        }

        Optional<ServiceEntry> lastEntry =
                serviceEntryRepository.findTopByVehicleOrderByOdometerReadingDesc(vehicle);

        if (lastEntry.isPresent() &&
                entry.getOdometerReading() < lastEntry.get().getOdometerReading()) {
            throw new IllegalArgumentException("Odometer reading must be >= previous reading");
        }

        return serviceEntryRepository.save(entry);
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        return serviceEntryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> getAllServiceEntries() {
        return serviceEntryRepository.findAll();
    }

    @Override
    public ServiceEntry updateServiceEntry(Long id, ServiceEntry updated) {
        ServiceEntry existing = getServiceEntryById(id);

        existing.setServiceType(updated.getServiceType());
        existing.setServiceDate(updated.getServiceDate());
        existing.setOdometerReading(updated.getOdometerReading());

        return serviceEntryRepository.save(existing);
    }

    @Override
    public void deleteServiceEntry(Long id) {
        serviceEntryRepository.deleteById(id);
    }
}
