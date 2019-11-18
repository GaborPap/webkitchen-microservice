package com.codecool.recipe.repository;

import com.codecool.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    void removeById(Long id);
}
