package com.example.clubmanagement.controller;

import com.example.clubmanagement.dto.UserDTO;
import com.example.clubmanagement.model.User;
import com.example.clubmanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO dto) {
        User savedUser = userService.createUser(dto);
        return ResponseEntity.ok(savedUser);
    }
}

