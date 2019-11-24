package com.codecool.ingredient;

import com.codecool.ingredient.model.Ingredient;
import com.codecool.ingredient.model.IngredientUnit;
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
              //   .ImageUrl("salt.jpg")
                .imageUrl("https://news.yale.edu/sites/default/files/styles/featured_media/public/adobestock_196225285.jpeg?itok=FyR9F85F&c=07307e7d6a991172b9f808eb83b18804")
                .unit(IngredientUnit.KG)
                .build();

        Ingredient sugar = Ingredient.builder()
                .name("Sugar")
                .description("Sugar is the generic name for sweet-tasting, soluble carbohydrates, many of which are used in food. Simple sugars, also called monosaccharides, include glucose, fructose, and galactose.")
             //   .ImageUrl("sugar.jpg")
                .imageUrl("https://images.immediate.co.uk/production/volatile/sites/4/2018/08/iStock_63854727_LARGE-a43c35e.jpg?quality=45&resize=960,413")
                .unit(IngredientUnit.KG)
                .build();

        Ingredient pepper = Ingredient.builder()
                .name("Pepper")
                .description("The chili pepper (also chile, chile pepper, chilli pepper, or chilli[4]), from Nahuatl chīlli (Nahuatl pronunciation: [ˈt͡ʃiːli] (About this soundlisten)), is the fruit of plants from the genus Capsicum which are members of the nightshade family,.")
              //  .ImageUrl("pepper.jpg")
                .unit(IngredientUnit.KG)
                .imageUrl("https://cdn.shopify.com/s/files/1/1537/5553/products/12416_1024x1024.jpg?v=1486447009")
                .build();

        Ingredient milk = Ingredient.builder()
                .name("Milk")
                .description("Milk is a nutrient-rich, white liquid food produced by the mammary glands of mammals. It is the primary source of nutrition for infant mammals (including humans who are breastfed) before they are able to digest other types of food. ")
                 //  .ImageUrl("pepper.jpg")
                .unit(IngredientUnit.LITER)
                .imageUrl("https://dairyfarmersofcanada.ca/sites/default/files/styles/full_width_large/public/getty-854296650.jpg?itok=oVdN6l2l")
                .build();

        ingredientRepository.save(salt);
        ingredientRepository.save(sugar);
        ingredientRepository.save(pepper);
        ingredientRepository.save(milk);



    }
}

