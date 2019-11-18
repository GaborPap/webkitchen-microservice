package com.codecool.recipe.controller;

import com.codecool.recipe.model.Recipe;
import com.codecool.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/")
    public List<Recipe> recipeList(){
        return recipeService.getAllRecipe();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable("id") Long id){
        return recipeService.getRecipeById(id);
    }

    @PostMapping("/")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        recipeService.addRecipe(recipe);
        return recipe;
    }
}

