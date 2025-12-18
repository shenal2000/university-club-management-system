package com.example.clubmanagement.service.impl;

import com.example.clubmanagement.dto.RoleGlobalDTO;
import com.example.clubmanagement.model.Role_global;
import com.example.clubmanagement.repository.RoleGlobalRepository;
import com.example.clubmanagement.service.RoleGlobalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleGlobalServiceImpl implements RoleGlobalService {

    private final RoleGlobalRepository repo;

    public RoleGlobalServiceImpl(RoleGlobalRepository repo) {
        this.repo = repo;
    }

    @Override
    public RoleGlobalDTO save(RoleGlobalDTO dto) {
        Role_global role = new Role_global();
        role.setRole(dto.getRole());
        repo.save(role);
        return dto;
    }

    @Override
    public List<RoleGlobalDTO> getAll() {
        List<RoleGlobalDTO> list = new ArrayList<>();
        for (Role_global r : repo.findAll()) {
            RoleGlobalDTO d = new RoleGlobalDTO();
            d.setRoleId(r.getRoleId());
            d.setRole(r.getRole());
            list.add(d);
        }
        return list;
    }
}
