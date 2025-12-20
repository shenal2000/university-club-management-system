package com.example.clubmanagement.service;

import com.example.clubmanagement.dto.RoleGlobalDTO;
import java.util.List;

public interface RoleGlobalService {

    RoleGlobalDTO save(RoleGlobalDTO dto);
    List<RoleGlobalDTO> getAll();
}
