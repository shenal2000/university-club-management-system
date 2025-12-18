package com.example.clubmanagement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "club")
public class club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "club_name")
    private String clubName;

    @Column(name = "description")
    private String description;

    @Column(name = "clubcategory_id")
    private Long clubCategoryId;

    @Column(name = "club_logo")
    private String clubLogo;

    // Constructors
    public club() {}

    // Getters and Setters
    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getClubCategoryId() {
        return clubCategoryId;
    }

    public void setClubCategoryId(Long clubCategoryId) {
        this.clubCategoryId = clubCategoryId;
    }

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }
}
