package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

import org.springframework.stereotype.Service;   // ✅ THIS WAS MISSING

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserRepository userRepository,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User register(User user) {
        userRepository.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new IllegalArgumentException("Email already exists");
        });
        return userRepository.save(user);
    }

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return jwtTokenProvider.generateToken(user.getEmail(), user.getRole());
    }
}
