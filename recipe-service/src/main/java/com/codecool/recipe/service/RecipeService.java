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

    public Recipe addRecipe(Recipe recipe){
        recipeRepository.save(recipe);
        return recipe;
    }

    public void deleteRecipe(Long id){
        recipeRepository.removeById(id);
    }

    public Recipe updateRecipe(Long id, Recipe recipe){
        if (recipe==null)
            return null;

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isPresent()){
            Recipe currentRecipe = recipeOptional.get();

            currentRecipe.setName(recipe.getName());
            currentRecipe.setDescription(recipe.getDescription());
            currentRecipe.setDirections(recipe.getDirections());
            currentRecipe.setServings(recipe.getServings());
            currentRecipe.setImage(recipe.getImage());
            currentRecipe.setIngredients(recipe.getIngredients());
            recipeRepository.save(currentRecipe);

            return currentRecipe;
        }
        return null;
    }
}
