package com.example.clubmanagement.service;

import com.example.clubmanagement.model.ClubMember;
import com.example.clubmanagement.model.ClubRole;
import com.example.clubmanagement.repository.ClubMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubMemberService {

    @Autowired
    private ClubMemberRepository clubMemberRepository;

    public ClubRole getUserRoleInClub(Long userId, Long clubId) {
        Optional<ClubMember> cm =
                clubMemberRepository.findByUserUserIdAndClubClubId(userId, clubId);

        return cm.map(ClubMember::getRole).orElse(null);
    }

    public List<ClubMember> getAllMembersByClub(Long clubId) {
        return clubMemberRepository.findAllByClubClubId(clubId);
    }

    public List<ClubMember> getAllMembers() {
        return clubMemberRepository.findAll();
    }

    public ClubMember addMember(ClubMember member) {
        return clubMemberRepository.save(member);
    }

    public ClubMember updateMember(Long id, ClubMember updated) {
        ClubMember member = clubMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        member.setRole(updated.getRole());
        member.setClub(updated.getClub());
        member.setUser(updated.getUser());

        return clubMemberRepository.save(member);
    }

    public void deleteMember(Long id) {
        if (!clubMemberRepository.existsById(id)) {
            throw new RuntimeException("Member not found");
        }
        clubMemberRepository.deleteById(id);
    }
}
