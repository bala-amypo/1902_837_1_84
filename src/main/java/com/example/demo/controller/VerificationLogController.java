package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;


@RestController
@RequestMapping("/verification-logs")
public class VerificationLogController {

    private final VerificationLogService verificationLogService;

    public VerificationLogController(VerificationLogService verificationLogService) {
        this.verificationLogService = verificationLogService;
    }

    @PostMapping
    public VerificationLog create(@RequestBody VerificationLog log) {
        return verificationLogService.createLog(log);
    }
}