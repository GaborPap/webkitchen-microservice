package com.codecool.ingredient.controller;

import com.codecool.ingredient.model.Ingredient;
import com.codecool.ingredient.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")

public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/")
    public List<Ingredient> getIngredients(){
        return ingredientService.getAllIngredient();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable("id") Long id){
        return ingredientService.getIngredientById(id);
    }

    @PostMapping("/")
    public Ingredient addIngredientToDb(@RequestBody Ingredient ingredient){
        ingredientService.add(ingredient);
        return ingredient;
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable("id") Long id, @RequestBody Ingredient ingredient){
        return ingredientService.updateRecommendation(id, ingredient);
    }


    @DeleteMapping("/{id}")
    public Ingredient removeIngredientById(@PathVariable("id") Long id){
        ingredientService.remove(id);
        return null;
    }
}
