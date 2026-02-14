package com.example.clubmanagement.repository;

import com.example.clubmanagement.model.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ClubMemberRepository extends JpaRepository<ClubMember, Long> {

    Optional<ClubMember> findByUserUserIdAndClubClubId(Long userId, Long clubId);

    List<ClubMember> findAllByClubClubId(Long clubId);

    List<ClubMember> findAllByUserUserId(Long userId);

    <T> ScopedValue<T> findByClub_ClubIdAndUser_UserId(Long clubId, Long userId);
}

