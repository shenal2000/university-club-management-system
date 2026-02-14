package com.example.clubmanagement.controller;

import com.example.clubmanagement.dto.ClubDTO;
import com.example.clubmanagement.model.Club;
import com.example.clubmanagement.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
@CrossOrigin(origins = "http://localhost:8080")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    // Create a club
    @PostMapping
    public ResponseEntity<Club> createClub(@RequestBody ClubDTO clubDTO) {
        Club createdClub = clubService.createClub(clubDTO);
        return new ResponseEntity<>(createdClub, HttpStatus.CREATED);
    }

    // Get all clubs
    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs() {
        return ResponseEntity.ok(clubService.getAllClubs());
    }

    // Get club by ID
    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable Long id) {
        return ResponseEntity.ok(clubService.getClubById(id));
    }


    @GetMapping("/category/{category}")
    public List<Club> getClubsByCategory(@PathVariable String category) {
        return clubService.getClubsByCategory(category);
    }

    // Update a club
    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(@PathVariable Long id, @RequestBody ClubDTO clubDTO) {
        Club existingClub = clubService.getClubById(id);

        existingClub.setClubName(clubDTO.getClubName());
        existingClub.setClubDescription(clubDTO.getClubDescription());
        existingClub.setClubLogo(clubDTO.getClubLogo());
        existingClub.setClubCategory(clubDTO.getClubCategory());

        Club updatedClub = clubService.updateClub(existingClub);
        return ResponseEntity.ok(updatedClub);
    }

    // Delete a club
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
        clubService.deleteClub(id);
        return ResponseEntity.noContent().build();
    }

}
