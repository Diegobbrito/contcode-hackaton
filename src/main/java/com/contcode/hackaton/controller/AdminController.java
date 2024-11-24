package com.contcode.hackaton.controller;

import com.contcode.hackaton.dto.UserDTO;
import com.contcode.hackaton.repository.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminController(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createAdmin(@RequestBody UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add("ADMIN");
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
