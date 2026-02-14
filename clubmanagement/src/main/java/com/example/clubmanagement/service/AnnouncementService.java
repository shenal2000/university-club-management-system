package com.example.clubmanagement.service;

import com.example.clubmanagement.model.Announcement;
import com.example.clubmanagement.model.Club;
import com.example.clubmanagement.repository.AnnouncementRepository;
import com.example.clubmanagement.repository.ClubRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepo;
    private final ClubRepository clubRepo;

    public AnnouncementService(AnnouncementRepository announcementRepo,
                               ClubRepository clubRepo) {
        this.announcementRepo = announcementRepo;
        this.clubRepo = clubRepo;
    }

    public List<Announcement> getActiveAnnouncements(Long clubId) {
        return announcementRepo.findByClub_ClubIdAndActiveTrue(clubId);
    }

    @Transactional
    public Announcement createAnnouncement(Long clubId, Announcement announcement) {
        Club club = clubRepo.findById(clubId)
                .orElseThrow(() -> new RuntimeException("Club not found"));
        announcement.setClub(club);
        return announcementRepo.save(announcement);
    }

    @Transactional
    public Announcement updateAnnouncement(Long announcementId, Announcement updated) {
        Announcement announcement = announcementRepo.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));

        announcement.setAnnouncementTitle(updated.getAnnouncementTitle());
        announcement.setAnnouncementDescription(updated.getAnnouncementDescription());

        return announcementRepo.save(announcement);
    }

    @Transactional
    public void deleteAnnouncement(Long announcementId) {
        announcementRepo.deleteById(announcementId);
    }
}
