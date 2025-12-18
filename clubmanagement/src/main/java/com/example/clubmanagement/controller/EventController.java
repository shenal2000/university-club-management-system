package com.example.clubmanagement.controller;

import com.example.clubmanagement.dto.EventDTO;
import com.example.clubmanagement.Model.Event;
import com.example.clubmanagement.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // Create Event
    @PostMapping
    public Event createEvent(@RequestBody EventDTO eventDTO) {
        return eventService.createEvent(eventDTO);
    }

    // Get all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Get events by club ID
    @GetMapping("/club/{clubId}")
    public List<Event> getEventsByClub(@PathVariable Long clubId) {
        return eventService.getEventsByClubId(clubId);
    }

    // Get event by ID
    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId);
    }

    // Delete event
    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }
}
