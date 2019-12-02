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
                .description("The chili pepper (also chile, chile pepper, chilli pepper, or chilli[4]), from Nahuatl chīlli  is the fruit of plants from the genus Capsicum which are members of the nightshade family.")
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

        Ingredient honey = Ingredient.builder()
                .name("Honey")
                .description("Honey is a sweet, viscous food substance made by bees and some related insects. Bees produce honey from the sugary secretions of plants (floral nectar) or from secretions of other insects (such as honeydew), by regurgitation, enzymatic activity, and water evaporation.")
                //  .ImageUrl("pepper.jpg")
                .unit(IngredientUnit.CUP)
                .imageUrl("https://ichef.bbci.co.uk/news/660/cpsprodpb/49EA/production/_103122981_honey.jpg")
                .build();

        Ingredient chocolate = Ingredient.builder()
                .name("Chocolate")
                .description("Chocolate is a usually sweet, brown food preparation of roasted and ground cacao seeds that is made in the form of a liquid, paste, or in a block, or used as a flavoring ingredient in other foods.")
                //  .ImageUrl("pepper.jpg")
                .unit(IngredientUnit.KG)
                .imageUrl("https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/07/07/14/melting-choc-istock.jpg?w968h681")
                .build();


        Ingredient mushroom = Ingredient.builder()
                .name("Mushroom")
                .description("A mushroom, or toadstool, is the fleshy, spore-bearing fruiting body of a fungus, typically produced above ground, on soil, or on its food source.")
                //  .ImageUrl("pepper.jpg")
                .unit(IngredientUnit.KG)
                .imageUrl("https://images-na.ssl-images-amazon.com/images/I/71LhWci7mFL._SX522_.jpg")
                .build();

        Ingredient butter = Ingredient.builder()
                .name("Butter")
                .description("Butter is a dairy product with high butterfat content which is solid when chilled and at room temperature in some regions, and liquid when warmed.")
                //  .ImageUrl("pepper.jpg")
                .unit(IngredientUnit.KG)
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/d/d3/%C5%A0v%C3%A9dsk%C3%BD_kol%C3%A1%C4%8D_naruby_904_%28cropped%29.JPG")
                .build();


        ingredientRepository.save(salt);  //1
        ingredientRepository.save(sugar); //2
        ingredientRepository.save(pepper); //3
        ingredientRepository.save(milk); //4
        ingredientRepository.save(honey); //5
        ingredientRepository.save(chocolate); //6
        ingredientRepository.save(mushroom); //7
        ingredientRepository.save(butter); //8






    }
}

