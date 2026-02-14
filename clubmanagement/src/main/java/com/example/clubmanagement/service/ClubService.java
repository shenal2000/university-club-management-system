package com.example.clubmanagement.service;

import com.example.clubmanagement.dto.ClubDTO;
import com.example.clubmanagement.model.Club;
import com.example.clubmanagement.model.ClubCategory;
import com.example.clubmanagement.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    // Create Club
    public Club createClub(ClubDTO dto) {
        if (clubRepository.existsByClubName(dto.getClubName())) {
            throw new RuntimeException("Club already exists");
        }

        Club club = new Club();
        club.setClubName(dto.getClubName());
        club.setClubDescription(dto.getClubDescription());
        club.setClubLogo(dto.getClubLogo());
        club.setClubCategory(dto.getClubCategory());

        return clubRepository.save(club);
    }

    // Get all clubs
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    // Get club by ID
    public Club getClubById(Long clubId) {
        return clubRepository.findById(clubId)
                .orElseThrow(() -> new RuntimeException("Club not found"));
    }
    //Get club by category
    public List<Club> getClubsByCategory(String categoryStr) {
        // Convert string to Enum
        ClubCategory category;
        try {
            category = ClubCategory.valueOf(categoryStr.toUpperCase()); // case-insensitive
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid club category: " + categoryStr);
        }
        return clubRepository.findByClubCategory(category);
    }

    // Update club
    public Club updateClub(Club club) {
        return clubRepository.save(club);
    }

    // Delete Club
    public void deleteClub(Long id) {
        if (!clubRepository.existsById(id)) {
            throw new RuntimeException("Club not found");
        }
        clubRepository.deleteById(id);
    }


}
