package com.university.clubmanagement.repository;

import com.university.clubmanagement.entity.ClubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubCategoryRepository
        extends JpaRepository<ClubCategory, Long> {
}
