package com.university.clubmanagement.controller;

import com.university.clubmanagement.dto.ClubCategoryDTO;
import com.university.clubmanagement.entity.ClubCategory;
import com.university.clubmanagement.service.ClubCategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ClubCategoryController {

    private final ClubCategoryService service;

    public ClubCategoryController(ClubCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ClubCategory createCategory(
            @Valid @RequestBody ClubCategoryDTO dto) {
        return service.createCategory(dto);
    }

    @GetMapping
    public List<ClubCategory> getAllCategories() {
        return service.getAllCategories();
    }
}
