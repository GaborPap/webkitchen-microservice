package com.codecool.recipe;

import com.codecool.recipe.model.Recipe;
import com.codecool.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataInitilaizer implements CommandLineRunner {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void run(String... args) throws Exception {
        Map<Integer, Integer> ingredients = new HashMap<>();
        ingredients.put(1, 2);
        ingredients.put(2,3);

        Recipe recipe = Recipe.builder()
                .ingredients(ingredients)
                .name("Recpie")
                .build();

        recipeRepository.save(recipe);

    }
}

