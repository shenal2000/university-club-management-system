package com.example.clubmanagement.config;

import com.example.clubmanagement.model.Role;
import com.example.clubmanagement.model.User;
import com.example.clubmanagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setFullName("Administrator");
                admin.setEmail("admin@example.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRoleGlobal(Role.ROLE_ADMIN);

                userRepository.save(admin);
                System.out.println("Admin user created: admin@example.com / admin123");
            }
        };
    }
}
