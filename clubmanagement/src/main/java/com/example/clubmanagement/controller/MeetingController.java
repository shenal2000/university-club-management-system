package com.example.clubmanagement.controller;

import com.example.clubmanagement.dto.MeetingDTO;
import com.example.clubmanagement.model.Meeting;
import com.example.clubmanagement.service.MeetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meeting")
@CrossOrigin
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    // GET all meeting of a club
    @GetMapping("/club/{clubId}")
    public List<Meeting> getMeetings(@PathVariable Long clubId) {
        return meetingService.getActiveMeetings(clubId);
    }

    // POST create meeting (no permission check for simplicity)
    @PostMapping("/club/{clubId}")
    public Meeting createMeeting(@PathVariable Long clubId, @RequestBody MeetingDTO dto) {
        Meeting meeting = new Meeting();
        meeting.setMeetingTitle(dto.getMeetingTitle());
        meeting.setMeetingDate(dto.getMeetingDate());
        meeting.setMeetingTime(dto.getMeetingTime());

        return meetingService.createMeeting(clubId, meeting);
    }

    // PUT update meeting
    @PutMapping("/{meetingId}")
    public Meeting updateMeeting(@PathVariable Long meetingId, @RequestBody MeetingDTO dto) {
        Meeting updated = new Meeting();
        updated.setMeetingTitle(dto.getMeetingTitle());
        updated.setMeetingDate(dto.getMeetingDate());
        updated.setMeetingTime(dto.getMeetingTime());

        return meetingService.updateMeeting(meetingId, updated);
    }

    // DELETE meeting
    @DeleteMapping("/{meetingId}")
    public void deleteMeeting(@PathVariable Long meetingId) {
        meetingService.deleteMeeting(meetingId);
    }
}

