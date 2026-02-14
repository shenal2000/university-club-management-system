package com.example.clubmanagement.repository;

import com.example.clubmanagement.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    List<Announcement> findByClub_ClubIdAndActiveTrue(Long clubId);
}
