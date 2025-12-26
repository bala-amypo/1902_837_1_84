package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;


@RestController
@RequestMapping("/garages")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping
    public Garage create(@RequestBody Garage garage) {
        return garageService.createGarage(garage);
    }
}