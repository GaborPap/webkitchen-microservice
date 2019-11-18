package com.codecool.webkitchen.controller;


import com.codecool.ingredient.model.Ingredient;
import com.codecool.recipe.model.Recipe;
import com.codecool.webkitchen.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipe();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable("id") Long id)
    {
        return recipeService.getRecipeById(id);
    }

    @PostMapping("/")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
    }
}
