package com.codecool.ingredient.service;

import com.codecool.ingredient.model.Ingredient;
import com.codecool.ingredient.model.IngredientUnit;
import com.codecool.ingredient.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Ingredient updateRecommendation(Long id, Ingredient ingredient){
        if (ingredient==null)
            return null;


        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
        if (ingredientOptional.isPresent()) {

            Ingredient currentIngredient = ingredientOptional.get();

            currentIngredient.setUnit(ingredient.getUnit());
            currentIngredient.setDescription(ingredient.getDescription());
            currentIngredient.setImageUrl(ingredient.getImageUrl());
            currentIngredient.setName(ingredient.getName());
            ingredientRepository.save(currentIngredient);

            return currentIngredient;
        }
        return null;
    }

    public String getUnits(){
        List<String> enumNames = Stream.of(IngredientUnit.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return String.join(",", enumNames);
    }
}
