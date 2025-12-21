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
        return garageRepository.save(garage);
    }

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id).orElse(null);
    }

    @Override
    public Garage updateGarage(Long id, Garage garage) {
        garage.setId(id);
        return garageRepository.save(garage);
    }

    @Override
    public void deleteGarage(Long id) {
        garageRepository.deleteById(id);
    }
}
