package com.codecool.webkitchen.service;

import com.codecool.recipe.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${recipes.url}")
    private String recipesUrl;

    public List<Recipe> getAllRecipe(){

        ResponseEntity<List<Recipe>> response = restTemplate.exchange(
                recipesUrl + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Recipe>>() {
                }
        );
        return response.getBody();
    }



    public Recipe addRecipe(Recipe recipe){
        HttpEntity<Recipe> request = new HttpEntity<>(recipe);
        return restTemplate.postForObject(recipesUrl + "/", request, Recipe.class);
    }

    public Recipe getRecipeById(Long id) {
        return restTemplate.getForEntity(recipesUrl + "/" +id, Recipe.class).getBody();
    }

    public void deleteRecipe(Long id){
        restTemplate.delete(recipesUrl + "/"+ id);
    }

    public void updateRecipe(Long id, Recipe recipe){
        HttpEntity<Recipe> request = new HttpEntity<>(recipe);
        restTemplate.put(recipesUrl+ "/" + id, request, Recipe.class);
    }

}
