package com.example.clubmanagement.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventDTO {

    private Long eventId;
    private Long clubId;
    private String eventTitle;
    private String eventDescription;
    private LocalTime eventTime;
    private LocalDate eventDate;
    private String location;

    public Long getClubId() {return clubId;}
    public void setClubId(Long clubId) {this.clubId = clubId;}
    public Long getEventId() {return eventId;}
    public void setEventId(Long eventId) {this.eventId = eventId;}
    public String getEventTitle() {return eventTitle;}
    public void setEventTitle(String eventTitle) {this.eventTitle = eventTitle;}
    public String getEventDescription() {return eventDescription;}
    public void setEventDescription(String eventDescription) {this.eventDescription = eventDescription;}
    public LocalTime getEventTime() {return eventTime;}
    public void setEventTime(LocalTime eventTime) {this.eventTime = eventTime;}
    public LocalDate getEventDate() {return eventDate;}
    public void setEventDate(LocalDate eventDate) {this.eventDate = eventDate;}
    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

}
