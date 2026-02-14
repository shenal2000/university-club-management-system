package com.example.clubmanagement.controller;

import com.example.clubmanagement.model.Club;
import com.example.clubmanagement.model.ClubMember;
import com.example.clubmanagement.model.ClubRole;
import com.example.clubmanagement.service.ClubMemberService;
import com.example.clubmanagement.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/club-members")
@CrossOrigin(origins = "*")
public class ClubMemberController {

    @Autowired
    private ClubMemberService clubMemberService;

    @Autowired
    private ClubService clubService;

    // CLUB DETAILS WITH ROLE
    @GetMapping("/club/{clubId}/details")
    public ResponseEntity<?> getClubDetailsWithRole(
            @PathVariable Long clubId,
            @RequestParam(required = false) Long userId) {

        Club club = clubService.getClubById(clubId);
        if (club == null) {
            return ResponseEntity.status(404).body("Club not found");
        }

        ClubRole role = null;
        if (userId != null) {
            role = clubMemberService.getUserRoleInClub(userId, clubId);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("clubId", club.getClubId());
        response.put("clubName", club.getClubName());
        response.put("clubDescription", club.getClubDescription());
        response.put("clubLogo", club.getClubLogo());
        response.put("role", role != null ? role.name() : "NON_MEMBER");

        return ResponseEntity.ok(response);
    }

    // GET ALL MEMBERS
    @GetMapping
    public List<ClubMember> getAllMembers() {
        return clubMemberService.getAllMembers();
    }

    // GET MEMBERS BY CLUB
    @GetMapping("/club/{clubId}")
    public List<ClubMember> getMembersByClub(@PathVariable Long clubId) {
        return clubMemberService.getAllMembersByClub(clubId);
    }

    //ADD MEMBER
    @PostMapping
    public ResponseEntity<ClubMember> addMember(@RequestBody ClubMember member) {
        return ResponseEntity.ok(clubMemberService.addMember(member));
    }

    // UPDATE MEMBER
    @PutMapping("/{id}")
    public ResponseEntity<ClubMember> updateMember(
            @PathVariable Long id,
            @RequestBody ClubMember member) {

        return ResponseEntity.ok(clubMemberService.updateMember(id, member));
    }

    // DELETE MEMBER
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        clubMemberService.deleteMember(id);
        return ResponseEntity.ok("Member deleted successfully");
    }
}
