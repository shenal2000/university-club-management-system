package com.example.clubmanagement.service;
import com.example.clubmanagement.model.Club;
import com.example.clubmanagement.model.Meeting;
import com.example.clubmanagement.repository.ClubRepository;
import com.example.clubmanagement.repository.MeetingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MeetingService {

    private final MeetingRepository meetingRepo;
    private final ClubRepository clubRepo;

    public MeetingService(MeetingRepository meetingRepo, ClubRepository clubRepo) {
        this.meetingRepo = meetingRepo;
        this.clubRepo = clubRepo;
    }

    public List<Meeting> getActiveMeetings(Long clubId) {
        return meetingRepo.findByClub_ClubIdAndActiveTrue(clubId);
    }

    @Transactional
    public Meeting createMeeting(Long clubId, Meeting meeting) {
        Club club = clubRepo.findById(clubId)
                .orElseThrow(() -> new RuntimeException("Club not found"));
        meeting.setClub(club);
        return meetingRepo.save(meeting);
    }

    @Transactional
    public Meeting updateMeeting(Long meetingId, Meeting updated) {
        Meeting meeting = meetingRepo.findById(meetingId)
                .orElseThrow(() -> new RuntimeException("Meeting not found"));

        meeting.setMeetingTitle(updated.getMeetingTitle());
        meeting.setMeetingDate(updated.getMeetingDate());
        meeting.setMeetingTime(updated.getMeetingTime());

        return meetingRepo.save(meeting);
    }

    @Transactional
    public void deleteMeeting(Long meetingId) {
        meetingRepo.deleteById(meetingId);
    }
}
