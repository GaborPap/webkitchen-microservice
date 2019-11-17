package com.codecool.ingredient.service;

import com.codecool.ingredient.model.Ingredient;
import com.codecool.ingredient.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredient(){
        return  ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(Long id){
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);

        return ingredient.orElse(null);

    }

    public void add(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public void remove(Long id) {
        ingredientRepository.removeById(id);
    }
}

