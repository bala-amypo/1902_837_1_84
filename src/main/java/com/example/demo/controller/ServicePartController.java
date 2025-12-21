package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
@Tag(name = "ServicePart")
public class ServicePartController {

    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    @PostMapping
    public ServicePart createServicePart(@RequestBody ServicePart part) {
        return servicePartService.createServicePart(part);
    }

    @GetMapping
    public List<ServicePart> getAllServiceParts() {
        return servicePartService.getAllServiceParts();
    }

    @GetMapping("/{id}")
    public ServicePart getServicePartById(@PathVariable Long id) {
        return servicePartService.getServicePartById(id);
    }

    @PutMapping("/{id}")
    public ServicePart updateServicePart(@PathVariable Long id,
                                         @RequestBody ServicePart part) {
        return servicePartService.updateServicePart(id, part);
    }

    @DeleteMapping("/{id}")
    public void deleteServicePart(@PathVariable Long id) {
        servicePartService.deleteServicePart(id);
    }
}
