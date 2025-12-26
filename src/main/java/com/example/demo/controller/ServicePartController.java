package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;


@RestController
@RequestMapping("/service-parts")
public class ServicePartController {

    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    @PostMapping
    public ServicePart create(@RequestBody ServicePart part) {
        return servicePartService.createPart(part);
    }
}