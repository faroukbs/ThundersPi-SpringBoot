package com.roky.thunderspi.repositories;

import com.roky.thunderspi.entities.QuizCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizCategoryRepo extends JpaRepository<QuizCategory,Long> {
}
