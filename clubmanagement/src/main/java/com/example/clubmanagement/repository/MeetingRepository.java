package com.example.clubmanagement.repository;
import com.example.clubmanagement.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByClub_ClubIdAndActiveTrue(Long clubId);
}
