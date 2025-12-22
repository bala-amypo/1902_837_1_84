package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    // ✅ REQUIRED BY TEST CASE
    public Garage createGarage(Garage garage) {
        return garageRepository.save(garage);
    }

    // Existing methods (keep them)
    @Override
    public Garage saveGarage(Garage garage) {
        return garageRepository.save(garage);
    }

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public Optional<Garage> getGarageById(Long id) {
        return garageRepository.findById(id);
    }

    @Override
    public Garage updateGarage(Long id, Garage garage) {
        return garageRepository.save(garage);
    }

    @Override
    public void deleteGarage(Long id) {
        garageRepository.deleteById(id);
    }
}
