package com.codecool.ingredient.repository;

import com.codecool.ingredient.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    void removeById(Long id);
}
