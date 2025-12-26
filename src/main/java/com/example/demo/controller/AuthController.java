package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.security.JwtTokenProvider;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String role,
                        @RequestParam Long userId) {
        return jwtTokenProvider.generateToken(email, role, userId);
    }
}