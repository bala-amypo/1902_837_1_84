package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;

import java.util.List;

public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {
        garageRepository.findByGarageName(garage.getGarageName()).ifPresent(g -> {
            throw new IllegalArgumentException("Garage already exists");
        });
        return garageRepository.save(garage);
    }

    @Override
    public Garage updateGarage(Long id, Garage garage) {
        Garage existing = getGarageById(id);
        existing.setAddress(garage.getAddress());
        existing.setContactNumber(garage.getContactNumber());
        return garageRepository.save(existing);
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));
    }

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public void deactivateGarage(Long id) {
        Garage garage = getGarageById(id);
        garage.setActive(false);
        garageRepository.save(garage);
    }
}
