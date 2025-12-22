package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {

        if (garageRepository.existsByName(garage.getName())) {
            throw new IllegalArgumentException("Garage with this name already exists");
        }

        return garageRepository.save(garage);
    }

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garage not found"));
    }

    @Override
    public Garage updateGarage(Long id, Garage updatedGarage) {
        Garage existing = getGarageById(id);
        existing.setName(updatedGarage.getName());
        existing.setLocation(updatedGarage.getLocation());
        return garageRepository.save(existing);
    }

    @Override
    public void deleteGarage(Long id) {
        garageRepository.deleteById(id);
    }
}
