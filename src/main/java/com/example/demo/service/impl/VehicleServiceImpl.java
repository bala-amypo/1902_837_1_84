package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle createVehicle(Vehicle v) {
        if (vehicleRepository.findByVin(v.getVin()).isPresent()) {
            throw new IllegalArgumentException("VIN already exists");
        }
        return vehicleRepository.save(v);
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    public List<Vehicle> getVehiclesByOwner(Long ownerId) {
        return vehicleRepository.findByOwnerId(ownerId);
    }

    public void deactivateVehicle(Long id) {
        Vehicle v = getVehicleById(id);
        v.setActive(false);
        vehicleRepository.save(v);
    }

    public Vehicle getVehicleByVin(String vin) {
        return vehicleRepository.findByVin(vin)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }
}
