package com.example.clubmanagement.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "club_id", nullable = false)
    private Long clubId;

    @Column(name = "event_title", nullable = false)
    private String eventTitle;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "event_time")
    private LocalTime eventTime;

    @Column(name = "event_date")
    private LocalDate eventDate;

    @Column(name = "location")
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

