package com.university.clubmanagement.service;

import com.university.clubmanagement.dto.ClubCategoryDTO;
import com.university.clubmanagement.entity.ClubCategory;

import java.util.List;

public interface ClubCategoryService {

    ClubCategory createCategory(ClubCategoryDTO dto);

    List<ClubCategory> getAllCategories();
}
