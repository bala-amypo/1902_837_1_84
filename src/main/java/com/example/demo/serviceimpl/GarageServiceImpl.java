package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GarageServiceImpl {

    @Autowired
    private GarageRepository garageRepository;

    public Garage createGarage(Garage g) {
        if (garageRepository.findByGarageName(g.getGarageName()).isPresent()) {
            throw new IllegalArgumentException("Garage already exists");
        }
        return garageRepository.save(g);
    }
}
