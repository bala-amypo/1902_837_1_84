package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
@Tag(name = "ServiceEntry")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;

    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    @PostMapping
    public ServiceEntry createServiceEntry(@RequestBody ServiceEntry entry) {
        return serviceEntryService.createServiceEntry(entry);
    }

    @GetMapping
    public List<ServiceEntry> getAllServiceEntries() {
        return serviceEntryService.getAllServiceEntries();
    }

    @GetMapping("/{id}")
    public ServiceEntry getServiceEntryById(@PathVariable Long id) {
        return serviceEntryService.getServiceEntryById(id);
    }

    @PutMapping("/{id}")
    public ServiceEntry updateServiceEntry(@PathVariable Long id,
                                           @RequestBody ServiceEntry entry) {
        return serviceEntryService.updateServiceEntry(id, entry);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceEntry(@PathVariable Long id) {
        serviceEntryService.deleteServiceEntry(id);
    }
}
