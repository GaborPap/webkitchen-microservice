package com.codecool.recipe.controller;

import com.codecool.recipe.model.Recipe;
import com.codecool.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("/{id}")
    public HttpEntity deleteRecipe(@PathVariable("id") Long id){
        recipeService.deleteRecipe(id);
        return new HttpEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipe){
        return recipeService.updateRecipe(id, recipe);
    }
}

