package com.example.clubmanagement.dto;

public class clubdto {

    private Long clubId;
    private String clubName;
    private String description;
    private Long clubCategoryId;
    private String clubLogo;

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
