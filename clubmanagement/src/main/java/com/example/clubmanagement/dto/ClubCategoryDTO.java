package com.university.clubmanagement.dto;

import jakarta.validation.constraints.NotBlank;

public class ClubCategoryDTO {

    @NotBlank
    private String categoryName;

    private String categoryDescription;

    // getters & setters
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
