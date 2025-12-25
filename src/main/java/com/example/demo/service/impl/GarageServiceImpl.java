package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageServiceImpl implements GarageService {

    @Override
    public Garage createGarage(Garage garage) {
        return garage;
    }

    @Override
    public List<Garage> getAllGarages() {
        return List.of();
    }

    @Override
    public Optional<Garage> getGarageById(Long id) {
        return Optional.empty();
    }

    @Override
    public Garage updateGarage(Long id, Garage garage) {
        return garage;
    }

    @Override
    public void deleteGarage(Long id) {
        // no implementation needed
    }
}
