package com.example.clubmanagement.repository;
import com.example.clubmanagement.model.Club;
import com.example.clubmanagement.model.ClubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Long> {

    boolean existsByClubName(String clubName);
    List<Club> findByClubCategory(ClubCategory category);
}