package com.example.demo.serviceimpl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServiceEntry addService(ServiceEntry entry) {

        Vehicle vehicle = entry.getVehicle();
        if (vehicle == null || !Boolean.TRUE.equals(vehicle.getActive())) {
            throw new IllegalArgumentException("Vehicle is inactive or missing");
        }

        Garage garage = entry.getGarage();
        if (garage == null || !Boolean.TRUE.equals(garage.getActive())) {
            throw new IllegalArgumentException("Garage is inactive or missing");
        }

        // 🔧 FIX: LocalDate comparison
        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Service date cannot be in the future");
        }

        List<ServiceEntry> history =
                serviceEntryRepository.findByVehicleId(vehicle.getId());

        if (!history.isEmpty()) {
            ServiceEntry last = history.get(history.size() - 1);
            if (entry.getOdometerReading() < last.getOdometerReading()) {
                throw new IllegalArgumentException("Odometer reading must be increasing");
            }
        }

        return serviceEntryRepository.save(entry);
    }

    @Override
    public ServiceEntry getById(Long id) {
        return serviceEntryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service entry not found"));
    }
}
