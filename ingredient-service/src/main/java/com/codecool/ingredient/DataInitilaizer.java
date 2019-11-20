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
             //   .ImageUrl("salt.jpg")
                .imageUrl("https://news.yale.edu/sites/default/files/styles/featured_media/public/adobestock_196225285.jpeg?itok=FyR9F85F&c=07307e7d6a991172b9f808eb83b18804")
                .build();

        Ingredient sugar = Ingredient.builder()
                .name("Sugar")
                .description("Sugar is the generic name for sweet-tasting, soluble carbohydrates, many of which are used in food. Simple sugars, also called monosaccharides, include glucose, fructose, and galactose.")
                .amount(1)
             //   .ImageUrl("sugar.jpg")
                .imageUrl("https://images.immediate.co.uk/production/volatile/sites/4/2018/08/iStock_63854727_LARGE-a43c35e.jpg?quality=45&resize=960,413")
                .build();

        Ingredient pepper = Ingredient.builder()
                .name("Pepper")
                .description("The chili pepper (also chile, chile pepper, chilli pepper, or chilli[4]), from Nahuatl chīlli (Nahuatl pronunciation: [ˈt͡ʃiːli] (About this soundlisten)), is the fruit of plants from the genus Capsicum which are members of the nightshade family,.")
                .amount(2)
              //  .ImageUrl("pepper.jpg")
                .imageUrl("https://cdn.shopify.com/s/files/1/1537/5553/products/12416_1024x1024.jpg?v=1486447009")
                .build();


        ingredientRepository.save(salt);
        ingredientRepository.save(sugar);
        ingredientRepository.save(pepper);



    }
}

