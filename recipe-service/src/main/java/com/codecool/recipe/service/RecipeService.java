package com.codecool.recipe.service;

import com.codecool.recipe.model.Recipe;
import com.codecool.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;


    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipe(){
        return recipeRepository.findAll();
    }


    public Recipe getRecipeById(Long id){
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.orElse(null);
    }
}