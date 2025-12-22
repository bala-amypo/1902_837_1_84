package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl {

    @Autowired private VehicleRepository vehicleRepository;
    @Autowired private GarageRepository garageRepository;
    @Autowired private ServiceEntryRepository serviceEntryRepository;

    public ServiceEntry createServiceEntry(ServiceEntry e) {

        Vehicle v = vehicleRepository.findById(e.getVehicle().getId()).orElseThrow();
        Garage g = garageRepository.findById(e.getGarage().getId()).orElseThrow();

        if (!v.getActive())
            throw new IllegalArgumentException("Only active vehicles allowed");

        if (e.getServiceDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Service date cannot be future");

        serviceEntryRepository.findTopByVehicleOrderByOdometerReadingDesc(v)
                .ifPresent(last -> {
                    if (e.getOdometerReading() < last.getOdometerReading()) {
                        throw new IllegalArgumentException("Odometer must be >=");
                    }
                });

        return serviceEntryRepository.save(e);
    }

    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }
}
