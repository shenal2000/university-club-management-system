package com.example.clubmanagement.dto;


import com.example.clubmanagement.model.ClubCategory;

public class ClubDTO {

    private String clubName;
    private String clubDescription;
    private String clubLogo;
    private ClubCategory clubCategory;

    // Getters & Setters
    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubDescription() {
        return clubDescription;
    }

    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }

    public ClubCategory getClubCategory() {
        return clubCategory;
    }

    public void setClubCategory(ClubCategory clubCategory) {
        this.clubCategory = clubCategory;
    }
}