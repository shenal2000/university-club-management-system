package com.university.clubmanagement.service.impl;

import com.university.clubmanagement.dto.ClubCategoryDTO;
import com.university.clubmanagement.entity.ClubCategory;
import com.university.clubmanagement.repository.ClubCategoryRepository;
import com.university.clubmanagement.service.ClubCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubCategoryServiceImpl implements ClubCategoryService {

    private final ClubCategoryRepository repository;

    public ClubCategoryServiceImpl(ClubCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClubCategory createCategory(ClubCategoryDTO dto) {
        ClubCategory category = new ClubCategory();
        category.setCategoryName(dto.getCategoryName());
        category.setCategoryDescription(dto.getCategoryDescription());
        return repository.save(category);
    }

    @Override
    public List<ClubCategory> getAllCategories() {
        return repository.findAll();
    }
}
