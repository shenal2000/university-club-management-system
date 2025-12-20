package com.example.clubmanagement.controller;

import com.example.clubmanagement.Model.club;
import com.example.clubmanagement.dto.clubdto;
import com.example.clubmanagement.service.clubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class clubController {

    private final clubService clubService;

    public clubController(clubService clubService) {
        this.clubService = clubService;
    }

    // Create club
    @PostMapping
    public club createClub(@RequestBody clubdto dto) {
        return clubService.saveClub(dto);
    }

    // Get all clubs
    @GetMapping
    public List<club> getAllClubs() {
        return clubService.getAllClubs();
    }
}
