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
        ingredients.put(1, 1);
        ingredients.put(3, 1);

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
        ingredients_sajt.put(3, 1);
        ingredients_sajt.put(4, 1);
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
        ingredients_parizsi.put(4, 1);

        Recipe parizsi = Recipe.builder()
                .ingredients(ingredients_parizsi)
                .name("Pumpkin Pies")
                .description("A delicious pumpkin cookie that can be eaten single or filled with whoopie.")
                .image("https://images.media-allrecipes.com/userphotos/720x405/744202.jpg")
                .directions("Preheat oven to 350 degrees F (175 degrees C). Lightly grease baking sheets. Combine the oil and brown sugar. Mix in the pumpkin and eggs, beating well. Add the flour, salt, baking powder, baking soda, 1 teaspoon vanilla, cinnamon, ginger and cloves. Mix well.")
                .servings(2)
                .build();

        Map<Integer, Integer> ingredients_menu_one = new HashMap<>();
        ingredients_parizsi.put(1, 2);
        ingredients_parizsi.put(2, 1);
        ingredients_parizsi.put(3, 1);
        ingredients_parizsi.put(4, 1);

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


        ////////////////////////////////////////////////////////////////////////////////////////
        Map<Integer, Integer> chicken_ing = new HashMap<>();
        chicken_ing.put(1, 2);
        chicken_ing.put(4, 1);
        chicken_ing.put(5, 2);

        Recipe chicken = Recipe.builder()
                .ingredients(chicken_ing)
                .name("Honey Chicken")
                .description("Garnish with thinly sliced green onions, if desired.")
                .image("https://mediterran.cafeblog.hu/files/2019/02/A-legropog%C3%B3sabb-h%C3%A1zi-s%C3%BClt-krumpli-titka-glut%C3%A9nmentes2.jpg")
                .directions("Mix honey, tomato paste, apple cider vinegar, Sriracha sauce, and sesame oil together in a medium bowl. Step 2 Combine cold water, cornstarch, and 1/2 teaspoon salt in a bowl; mix well. Add to honey sauce mixture and mix well. Set aside until needed. Step 3 Sprinkle 1/4 teaspoon salt and 1/4 teaspoon garlic powder over chicken.")
                .servings(1)
                .build();

        Map<Integer, Integer>  chocolate_cake_ing= new HashMap<>();
        chocolate_cake_ing.put(1, 1);
        chocolate_cake_ing.put(2, 3);
        chocolate_cake_ing.put(3, 3);
        chocolate_cake_ing.put(6, 2);
        Recipe chocolate_cake = Recipe.builder()
                .ingredients(chocolate_cake_ing)
                .name("Chocolate Cake")
                .description("This recipe features an icing made with cream cheese, cocoa, and cinnamon frosts this dark chocolate cake for an elegant dessert")
                .image("https://images.media-allrecipes.com/userphotos/720x405/844348.jpg")
                .directions("Preheat oven to 350 degrees F (175 degrees C). Grease 3 - 9 inch round cake pans. In medium bowl, pour boiling water over cocoa, and whisk until smooth. Let mixture cool. Sift together flour, baking soda, baking powder and salt; set aside." +
                        "In a large bowl, cream butter and sugar together until light and fluffy. Beat in eggs one at time, then stir in vanilla. Add the flour mixture alternately with the cocoa mixture. Spread batter evenly between the 3 prepared pans." +
                        "Bake in preheated oven for 25 to 30 minutes. Allow to cool..")
                .servings(2)
                .build();


        Map<Integer, Integer> ingredients_mushroom_sauce = new HashMap<>();
        ingredients_mushroom_sauce.put(1, 1);
        ingredients_mushroom_sauce.put(2, 1);
        ingredients_mushroom_sauce.put(4, 1);
        ingredients_mushroom_sauce.put(7, 4);
        ingredients_mushroom_sauce.put(8, 2);


        Recipe mushroom_sauce = Recipe.builder()
                .ingredients(ingredients_mushroom_sauce)
                .name("Mushroom Sauce")
                .description("This sauce is excellent over most grilled meats, including veal or beef medallions.")
                .image("https://images.media-allrecipes.com/userphotos/560x315/2428593.jpg")
                .directions("Melt butter in a saucepan over medium heat. Saute shallots briefly, then stir in all of the mushrooms. Saute until tender and translucent, about 3 minutes. Pour in red wine, and simmer for 3 minutes. Stir in demi glace, and simmer for 6 minutes, or until sauce has thickened.")
                .servings(2)
                .build();

        Map<Integer, Integer> ingredientsLinzerCookies = new HashMap<>();
        ingredientsLinzerCookies.put(1, 1);
        ingredientsLinzerCookies.put(2, 3);
        ingredientsLinzerCookies.put(4, 1);
        ingredientsLinzerCookies.put(8, 2);

        Recipe linzerCookies = Recipe.builder()
                .ingredients(ingredientsLinzerCookies)
                .name("Linzer Cookies")
                .description("These are a version of a classic Austrian dessert. A nutty dough with preserves and a lattice top. A beautiful treat for the holidays")
                .image("https://images.media-allrecipes.com/userphotos/720x405/4589657.jpg")
                .directions("In a medium bowl, cream together the butter and sugar. Beat in the egg and lemon peel. In another bowl, stir together the flour, almonds, cinnamon and cloves. Gradually stir the dry ingredients into the creamed mixture. The dough will be stiff, so you may need to knead it by hand to get it to come together. Press half of the dough into the bottom of the prepared pan.")
                .servings(1)
                .build();


        recipeRepository.save(chicken);
        recipeRepository.save(chocolate_cake);
        recipeRepository.save(mushroom_sauce);
        recipeRepository.save(linzerCookies);
/*
        Recipe recipe2 = Recipe.builder()
                .ingredients(ingredients)
                .name("French fries")
                .description("Description of French fries.")
                .image("https://mediterran.cafeblog.hu/files/2019/02/A-legropog%C3%B3sabb-h%C3%A1zi-s%C3%BClt-krumpli-titka-glut%C3%A9nmentes2.jpg")
                .directions("ut the potatoes lengthwise into 1/4-inch-thick slices, then cut each slice lengthwise into 1/4-inch-thick fries. Put the fries in a large bowl of cold water and refrigerate for at least 1 hour or up to 8 hours.")
                .servings(1)
                .build();

        Recipe cheese2 = Recipe.builder()
                .ingredients(ingredients_sajt)
                .name("Fried cheese")
                .description("Fried cheese is a dish prepared using cheese that is fried in oil.")
                .image("https://kep.cdn.indexvas.hu/1/0/1877/18770/187708/18770865_216b5062d3bc18253f023449fe44f88b_wm.jpg")
                .directions("Sprinkle cheese with optional salt, if desired. Dredge slices in flour, then in beaten egg, and finally in bread crumbs, making sure the cheese slices are completely covered. Pan fry quickly in hot oil or shortening until golden brown. Serve immediately.")
                .servings(2)
                .build();


        Recipe parizsi2 = Recipe.builder()
                .ingredients(ingredients_parizsi)
                .name("Pumpkin Whoopie Pies")
                .description("A delicious pumpkin cookie that can be eaten single or filled with whoopie pie filling to make it even better.")
                .image("https://images.media-allrecipes.com/userphotos/720x405/744202.jpg")
                .directions("Preheat oven to 350 degrees F (175 degrees C). Lightly grease baking sheets. Combine the oil and brown sugar. Mix in the pumpkin and eggs, beating well. Add the flour, salt, baking powder, baking soda, 1 teaspoon vanilla, cinnamon, ginger and cloves. Mix well.")
                .servings(2)
                .build();

        Recipe menuone2 = Recipe.builder()
                .ingredients(ingredients_parizsi)
                .name("Perfect Turkey")
                .description("A perfectly seasoned and juicy turkey. My friend from France taught me to cook turkey like this, but she never measures anything so use your own judgment for vegetable amounts, etc. I usually err on the side of 'more is better")
                .image("https://images.media-allrecipes.com/userphotos/720x405/6573896.jpg")
                .directions("Rub the turkey inside and out with the kosher salt. Place the bird in a large stock pot, and cover with cold water. Place in the refrigerator, and allow the turkey to soak in the salt and water mixture 12 hours, or overnight.t")
                .servings(1)
                .build();


        recipeRepository.save(recipe2);
        recipeRepository.save(cheese2);
        recipeRepository.save(parizsi2);
        recipeRepository.save(menuone2);


        Recipe recipe3 = Recipe.builder()
                .ingredients(ingredients)
                .name("French fries")
                .description("Description of French fries.")
                .image("https://mediterran.cafeblog.hu/files/2019/02/A-legropog%C3%B3sabb-h%C3%A1zi-s%C3%BClt-krumpli-titka-glut%C3%A9nmentes2.jpg")
                .directions("ut the potatoes lengthwise into 1/4-inch-thick slices, then cut each slice lengthwise into 1/4-inch-thick fries. Put the fries in a large bowl of cold water and refrigerate for at least 1 hour or up to 8 hours.")
                .servings(1)
                .build();

        Recipe cheese3 = Recipe.builder()
                .ingredients(ingredients_sajt)
                .name("Fried cheese")
                .description("Fried cheese is a dish prepared using cheese that is fried in oil.")
                .image("https://kep.cdn.indexvas.hu/1/0/1877/18770/187708/18770865_216b5062d3bc18253f023449fe44f88b_wm.jpg")
                .directions("Sprinkle cheese with optional salt, if desired. Dredge slices in flour, then in beaten egg, and finally in bread crumbs, making sure the cheese slices are completely covered. Pan fry quickly in hot oil or shortening until golden brown. Serve immediately.")
                .servings(2)
                .build();


        Recipe parizsi3 = Recipe.builder()
                .ingredients(ingredients_parizsi)
                .name("Pumpkin Whoopie Pies")
                .description("A delicious pumpkin cookie that can be eaten single or filled with whoopie pie filling to make it even better.")
                .image("https://images.media-allrecipes.com/userphotos/720x405/744202.jpg")
                .directions("Preheat oven to 350 degrees F (175 degrees C). Lightly grease baking sheets. Combine the oil and brown sugar. Mix in the pumpkin and eggs, beating well. Add the flour, salt, baking powder, baking soda, 1 teaspoon vanilla, cinnamon, ginger and cloves. Mix well.")
                .servings(2)
                .build();

        Recipe menuone3 = Recipe.builder()
                .ingredients(ingredients_parizsi)
                .name("Perfect Turkey")
                .description("A perfectly seasoned and juicy turkey. My friend from France taught me to cook turkey like this, but she never measures anything so use your own judgment for vegetable amounts, etc. I usually err on the side of 'more is better")
                .image("https://images.media-allrecipes.com/userphotos/720x405/6573896.jpg")
                .directions("Rub the turkey inside and out with the kosher salt. Place the bird in a large stock pot, and cover with cold water. Place in the refrigerator, and allow the turkey to soak in the salt and water mixture 12 hours, or overnight.t")
                .servings(1)
                .build();


        recipeRepository.save(recipe3);
        recipeRepository.save(cheese3);
        recipeRepository.save(parizsi3);
        recipeRepository.save(menuone3);

*/
    }
}




