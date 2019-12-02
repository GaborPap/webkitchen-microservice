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
        ingredients.put(1,1);
        ingredients.put(3,1);

        Recipe recipe = Recipe.builder()
                .ingredients(ingredients)
                .name("French fries")
                .description("Description of French fries.")
                .image("https://mediterran.cafeblog.hu/files/2019/02/A-legropog%C3%B3sabb-h%C3%A1zi-s%C3%BClt-krumpli-titka-glut%C3%A9nmentes2.jpg")
                .directions("ut the potatoes lengthwise into 1/4-inch-thick slices, then cut each slice lengthwise into 1/4-inch-thick fries. Put the fries in a large bowl of cold water and refrigerate for at least 1 hour or up to 8 hours.")
                .servings(1)
                .build();

        Map<Integer, Integer> ingredients_sajt = new HashMap<>();
        ingredients_sajt.put(1, 2);
        ingredients_sajt.put(3,1);
        ingredients_sajt.put(4,1);
        Recipe cheese = Recipe.builder()
                .ingredients(ingredients_sajt)
                .name("Fried cheese")
                .description("Fried cheese is a dish prepared using cheese that is fried in oil.")
                .image("https://kep.cdn.indexvas.hu/1/0/1877/18770/187708/18770865_216b5062d3bc18253f023449fe44f88b_wm.jpg")
                .directions("Sprinkle cheese with optional salt, if desired. Dredge slices in flour, then in beaten egg, and finally in bread crumbs, making sure the cheese slices are completely covered. Pan fry quickly in hot oil or shortening until golden brown. Serve immediately.")
                .servings(2)
                .build();

        Map<Integer, Integer> ingredients_parizsi = new HashMap<>();
        ingredients_parizsi.put(2, 2);
        ingredients_parizsi.put(4,1);

        Recipe parizsi = Recipe.builder()
                .ingredients(ingredients_parizsi)
                .name("Pumpkin Pies")
                .description("A delicious pumpkin cookie that can be eaten single or filled with whoopie.")
                .image("https://images.media-allrecipes.com/userphotos/720x405/744202.jpg")
                .directions("Preheat oven to 350 degrees F (175 degrees C). Lightly grease baking sheets. Combine the oil and brown sugar. Mix in the pumpkin and eggs, beating well. Add the flour, salt, baking powder, baking soda, 1 teaspoon vanilla, cinnamon, ginger and cloves. Mix well.")
                .servings(2)
                .build();

        Map<Integer, Integer> ingredients_menu_one = new HashMap<>();
        ingredients_parizsi.put(1,2);
        ingredients_parizsi.put(2,1);
        ingredients_parizsi.put(3,1);
        ingredients_parizsi.put(4,1);

        Recipe menuone = Recipe.builder()
                .ingredients(ingredients_menu_one)
                .name("Perfect Turkey")
                .description("A perfectly seasoned and juicy turkey. ")
                .image("https://images.media-allrecipes.com/userphotos/720x405/6573896.jpg")
                .directions("Rub the turkey inside and out with the kosher salt. Place the bird in a large stock pot, and cover with cold water. Place in the refrigerator, and allow the turkey to soak in the salt and water mixture 12 hours, or overnight.t")
                .servings(1)
                .build();


        recipeRepository.save(recipe);
        recipeRepository.save(cheese);
        recipeRepository.save(parizsi);
        recipeRepository.save(menuone);

    }
}


