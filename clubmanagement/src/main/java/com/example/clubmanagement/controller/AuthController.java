package com.example.clubmanagement.controller;

import com.example.clubmanagement.dto.LoginRequestDTO;
import com.example.clubmanagement.model.User;
import com.example.clubmanagement.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepo;

    public AuthController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO dto) {

        User user = userRepo.findByUsername(dto.getUsername());

        if (user == null) {
            return ResponseEntity.status(401).body("User not found");
        }

        if (!user.getPassword().equals(dto.getPassword())) {
            return ResponseEntity.status(401).body("Wrong password");
        }

        // Return role (ADMIN / USER)
        return ResponseEntity.ok(user.getRole());
    }
}
