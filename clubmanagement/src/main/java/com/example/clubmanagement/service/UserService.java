package com.example.clubmanagement.service;

import com.example.clubmanagement.dto.UserDTO;
import com.example.clubmanagement.exception.AppException;
import com.example.clubmanagement.model.Role;
import com.example.clubmanagement.model.User;
import com.example.clubmanagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Create user (signup)
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new AppException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRoleGlobal() == null) {
            user.setRoleGlobal(Role.ROLE_USER);
        }

        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found"));
    }

    // Update user
    public User updateUser(Long id, UserDTO dto) {
        User user = getUserById(id);

        user.setUsername(dto.getUsername());
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setAge(dto.getAge());
        user.setFaculty(dto.getFaculty());
        user.setBatch(dto.getBatch());
        user.setDegree(dto.getDegree());

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        user.setRoleGlobal(Role.ROLE_USER);

        return userRepository.save(user);
    }

    // Delete user
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }



}
