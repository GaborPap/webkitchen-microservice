package com.codecool.ingredient;

import com.codecool.ingredient.model.Ingredient;
import com.codecool.ingredient.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitilaizer implements CommandLineRunner {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void run(String... args) throws Exception {
        Ingredient salt = Ingredient.builder()
                .name("salt")
                .build();

        Ingredient sugar = Ingredient.builder()
                .name("sugar")
                .build();


        ingredientRepository.save(salt);
        ingredientRepository.save(sugar);


    }
}

