package com.example.clubmanagement.service;

import com.example.clubmanagement.Model.club;
import com.example.clubmanagement.dto.clubdto;
import com.example.clubmanagement.repository.clubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clubService {

    private final clubRepository clubRepository;

    public clubService(clubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    // Save club
    public club saveClub(clubdto dto) {
        club c = new club();
        c.setClubName(dto.getClubName());
        c.setDescription(dto.getDescription());
        c.setClubCategoryId(dto.getClubCategoryId());
        c.setClubLogo(dto.getClubLogo());
        return clubRepository.save(c);
    }

    // Get all clubs
    public List<club> getAllClubs() {
        return clubRepository.findAll();
    }
}
