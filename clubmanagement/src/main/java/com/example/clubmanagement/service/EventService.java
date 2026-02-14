package com.example.clubmanagement.service;

import com.example.clubmanagement.model.Club;
import com.example.clubmanagement.model.Event;
import com.example.clubmanagement.repository.ClubRepository;
import com.example.clubmanagement.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepo;
    private final ClubRepository clubRepo;

    public EventService(EventRepository eventRepo, ClubRepository clubRepo) {
        this.eventRepo = eventRepo;
        this.clubRepo = clubRepo;
    }

    public List<Event> getActiveEvents(Long clubId) {
        return eventRepo.findByClub_ClubIdAndActiveTrue(clubId);
    }

    @Transactional
    public Event createEvent(Long clubId, Event event) {
        Club club = clubRepo.findById(clubId)
                .orElseThrow(() -> new RuntimeException("Club not found"));
        event.setClub(club);
        return eventRepo.save(event);
    }

    @Transactional
    public Event updateEvent(Long eventId, Event updated) {
        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setEventTitle(updated.getEventTitle());
        event.setEventDescription(updated.getEventDescription());
        event.setEventDate(updated.getEventDate());
        event.setEventTime(updated.getEventTime());
        event.setEventLocation(updated.getEventLocation());

        return eventRepo.save(event);
    }

    @Transactional
    public void deleteEvent(Long eventId) {
        eventRepo.deleteById(eventId);
    }
}
