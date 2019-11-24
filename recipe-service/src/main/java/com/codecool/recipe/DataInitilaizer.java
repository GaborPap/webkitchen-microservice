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
        ingredients.put(1, 112);
        ingredients.put(2,51);

        Recipe recipe = Recipe.builder()
                .ingredients(ingredients)
                .name("Sült krumpli")
                .description("Nagyon finom sült krumpli")
                .image("https://mediterran.cafeblog.hu/files/2019/02/A-legropog%C3%B3sabb-h%C3%A1zi-s%C3%BClt-krumpli-titka-glut%C3%A9nmentes2.jpg")
                .directions("Sokat kell sütni")
                .servings(1)
                .build();

        Map<Integer, Integer> ingredients_sajt = new HashMap<>();
        ingredients_sajt.put(1, 12);
        ingredients_sajt.put(2,31);
        ingredients_sajt.put(3,4);
        Recipe cheese = Recipe.builder()
                .ingredients(ingredients_sajt)
                .name("Rántott sajt")
                .description("Nagyon finom rántott")
                .image("https://kep.cdn.indexvas.hu/1/0/1877/18770/187708/18770865_216b5062d3bc18253f023449fe44f88b_wm.jpg")
                .directions("Sokat kell ebből is sütni")
                .servings(2)
                .build();

        Map<Integer, Integer> ingredients_parizsi = new HashMap<>();
        ingredients_parizsi.put(2, 20);
        ingredients_parizsi.put(4,13);

        Recipe parizsi = Recipe.builder()
                .ingredients(ingredients_parizsi)
                .name("Rántott párizsi")
                .description("Nagyon finom rántott")
                .image("http://www.foodyny.hu/images/rantottparizsi_3.png")
                .directions("Sokat kell ebből is sütni")
                .servings(2)
                .build();

        recipeRepository.save(recipe);
        recipeRepository.save(cheese);
        recipeRepository.save(parizsi);

    }
}

