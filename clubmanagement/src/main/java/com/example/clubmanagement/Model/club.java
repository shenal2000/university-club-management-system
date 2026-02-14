package com.example.clubmanagement.model;
import jakarta.persistence.*;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;

    @Column(nullable = false, unique = true)
    private String clubName;

    @Column(length = 1000)
    private String clubDescription;

    private String clubLogo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClubCategory clubCategory;

    // Getters & Setters
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