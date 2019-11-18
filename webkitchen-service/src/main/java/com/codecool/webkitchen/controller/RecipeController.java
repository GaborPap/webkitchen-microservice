package com.codecool.webkitchen.controller;


import com.codecool.ingredient.model.Ingredient;
import com.codecool.recipe.model.Recipe;
import com.codecool.webkitchen.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipe();
    }

}
