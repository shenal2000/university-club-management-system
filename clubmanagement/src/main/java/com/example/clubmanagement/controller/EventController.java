package com.example.clubmanagement.controller;

import com.example.clubmanagement.dto.EventDTO;
import com.example.clubmanagement.model.Event;
import com.example.clubmanagement.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // GET all events of a club
    @GetMapping("/club/{clubId}")
    public List<Event> getEvents(@PathVariable Long clubId) {
        return eventService.getActiveEvents(clubId);
    }

    // POST create event (no permission check for simplicity)
    @PostMapping("/club/{clubId}")
    public Event createEvent(@PathVariable Long clubId, @RequestBody EventDTO dto) {
        Event event = new Event();
        event.setEventTitle(dto.getEventTitle());
        event.setEventDescription(dto.getEventDescription());
        event.setEventDate(dto.getEventDate());
        event.setEventTime(dto.getEventTime());
        event.setEventLocation(dto.getEventLocation());

        return eventService.createEvent(clubId, event);
    }

    // PUT update event
    @PutMapping("/{eventId}")
    public Event updateEvent(@PathVariable Long eventId, @RequestBody EventDTO dto) {
        Event updated = new Event();
        updated.setEventTitle(dto.getEventTitle());
        updated.setEventDescription(dto.getEventDescription());
        updated.setEventDate(dto.getEventDate());
        updated.setEventTime(dto.getEventTime());
        updated.setEventLocation(dto.getEventLocation());

        return eventService.updateEvent(eventId, updated);
    }

    // DELETE event
    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }
}
