package com.example.clubmanagement.service;

import com.example.clubmanagement.dto.EventDTO;
import com.example.clubmanagement.Model.Event;
import com.example.clubmanagement.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(EventDTO dto) {
        Event event = new Event();
        event.setClubId(dto.getClubId());
        event.setEventTitle(dto.getEventTitle());
        event.setEventDescription(dto.getEventDescription());
        event.setEventDate(dto.getEventDate());
        event.setEventTime(dto.getEventTime());
        event.setLocation(dto.getLocation());

        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getEventsByClubId(Long clubId) {
        return eventRepository.findByClubId(clubId);
    }

    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
