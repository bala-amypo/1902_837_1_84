package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.*;

import java.time.LocalDateTime;
@Service
public class VerificationLogServiceImpl {

    private final VerificationLogRepository repo;
    private final ServiceEntryRepository entryRepo;

    public VerificationLogServiceImpl(VerificationLogRepository r, ServiceEntryRepository e) {
        this.repo = r;
        this.entryRepo = e;
    }

    public VerificationLog createLog(VerificationLog v) {
        entryRepo.findById(v.getServiceEntry().getId()).orElseThrow();
        v.setVerifiedAt(LocalDateTime.now());
        return repo.save(v);
    }
}
