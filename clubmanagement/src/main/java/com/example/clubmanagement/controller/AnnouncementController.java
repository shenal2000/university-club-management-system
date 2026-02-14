package com.example.clubmanagement.controller;

import com.example.clubmanagement.dto.AnnouncementDTO;
import com.example.clubmanagement.model.Announcement;
import com.example.clubmanagement.service.AnnouncementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
@CrossOrigin
public class AnnouncementController {

    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    // GET all announcements of a club
    @GetMapping("/club/{clubId}")
    public List<Announcement> getAnnouncements(@PathVariable Long clubId) {
        return announcementService.getActiveAnnouncements(clubId);
    }

    // POST create announcement
    @PostMapping("/club/{clubId}")
    public Announcement createAnnouncement(
            @PathVariable Long clubId,
            @RequestBody AnnouncementDTO dto) {

        Announcement announcement = new Announcement();
        announcement.setAnnouncementTitle(dto.getAnnouncementTitle());
        announcement.setAnnouncementDescription(dto.getAnnouncementDescription());

        return announcementService.createAnnouncement(clubId, announcement);
    }

    // PUT update announcement
    @PutMapping("/{announcementId}")
    public Announcement updateAnnouncement(
            @PathVariable Long announcementId,
            @RequestBody AnnouncementDTO dto) {

        Announcement updated = new Announcement();
        updated.setAnnouncementTitle(dto.getAnnouncementTitle());
        updated.setAnnouncementDescription(dto.getAnnouncementDescription());

        return announcementService.updateAnnouncement(announcementId, updated);
    }

    // DELETE announcement
    @DeleteMapping("/{announcementId}")
    public void deleteAnnouncement(@PathVariable Long announcementId) {
        announcementService.deleteAnnouncement(announcementId);
    }
}
