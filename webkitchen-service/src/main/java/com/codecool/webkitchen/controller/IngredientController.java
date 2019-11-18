package com.codecool.webkitchen.controller;

import com.codecool.ingredient.model.Ingredient;
import com.codecool.webkitchen.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {


    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/ingredient")
    public List<Ingredient> getIngredients(){
        return ingredientService.getIngredients();
    }

}
