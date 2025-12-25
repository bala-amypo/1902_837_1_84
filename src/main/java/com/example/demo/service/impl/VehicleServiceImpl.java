package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return List.of();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return Optional.empty(); // ✅ must be Optional
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        return vehicle;
    }

    @Override
    public void deleteVehicle(Long id) {
        // no implementation needed
    }
}
