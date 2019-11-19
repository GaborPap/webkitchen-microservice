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
                .name("Salt")
                .description("Salt is a mineral composed primarily of sodium chloride (NaCl), a chemical compound belonging to the larger class of salts; salt in its natural form as a crystalline mineral is known as rock salt or halite.")
                .amount(4)
                .ImageUrl("salt.jpg")
                .build();

        Ingredient sugar = Ingredient.builder()
                .name("Sugar")
                .description("Sugar is the generic name for sweet-tasting, soluble carbohydrates, many of which are used in food. Simple sugars, also called monosaccharides, include glucose, fructose, and galactose.")
                .amount(1)
                .ImageUrl("sugar.jpg")
                .build();

        Ingredient pepper = Ingredient.builder()
                .name("Pepper")
                .description("The chili pepper (also chile, chile pepper, chilli pepper, or chilli[4]), from Nahuatl chīlli (Nahuatl pronunciation: [ˈt͡ʃiːli] (About this soundlisten)), is the fruit of plants from the genus Capsicum which are members of the nightshade family,.")
                .amount(2)
                .ImageUrl("pepper.jpg")
                .build();


        ingredientRepository.save(salt);
        ingredientRepository.save(sugar);
        ingredientRepository.save(pepper);



    }
}

