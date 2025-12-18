package com.example.clubmanagement.controller;

import com.example.clubmanagement.dto.RoleGlobalDTO;
import com.example.clubmanagement.service.RoleGlobalService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleGlobalController {

    private final RoleGlobalService service;

    public RoleGlobalController(RoleGlobalService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public RoleGlobalDTO save(@RequestBody RoleGlobalDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','CLUB_ADMIN')")
    public List<RoleGlobalDTO> getAll() {
        return service.getAll();
    }
}
