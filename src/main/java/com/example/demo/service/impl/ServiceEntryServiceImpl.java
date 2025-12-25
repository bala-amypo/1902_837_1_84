package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.time.LocalDate;
@Service
public class ServiceEntryServiceImpl {

    private final ServiceEntryRepository entryRepo;
    private final VehicleRepository vehicleRepo;
    private final GarageRepository garageRepo;

    public ServiceEntryServiceImpl(ServiceEntryRepository e, VehicleRepository v, GarageRepository g) {
        this.entryRepo = e;
        this.vehicleRepo = v;
        this.garageRepo = g;
    }

    public ServiceEntry createServiceEntry(ServiceEntry e) {

        Vehicle v = vehicleRepo.findById(e.getVehicle().getId()).orElseThrow();
        Garage g = garageRepo.findById(e.getGarage().getId()).orElseThrow();

        if (!v.getActive())
            throw new IllegalArgumentException("Only active vehicles allowed");

        if (e.getServiceDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Service date cannot be future");

        entryRepo.findTopByVehicleOrderByOdometerReadingDesc(v)
                .ifPresent(last -> {
                    if (e.getOdometerReading() < last.getOdometerReading())
                        throw new IllegalArgumentException("Odometer must be >=");
                });

        return entryRepo.save(e);
    }

    public java.util.List<ServiceEntry> getEntriesForVehicle(Long id) {
        return entryRepo.findByVehicleId(id);
    }
}
