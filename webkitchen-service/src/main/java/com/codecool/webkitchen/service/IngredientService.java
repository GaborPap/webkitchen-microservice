package com.codecool.webkitchen.service;

import com.codecool.ingredient.model.Ingredient;
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
public class IngredientService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ingredients.url}")
    private String ingredientUrl;

    public List<Ingredient> getIngredients() {
        ResponseEntity<List<Ingredient>> response = restTemplate.exchange(
                ingredientUrl + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Ingredient>>() {
                }
        );

        return response.getBody();
    }

    public Ingredient getIngredientById(Long id){
        return restTemplate.getForEntity(ingredientUrl + "/" +id, Ingredient.class).getBody();
    }

    public Ingredient addIngredient(Ingredient ingredient){
        HttpEntity<Ingredient> request = new HttpEntity<>(ingredient);
        return restTemplate.postForObject(ingredientUrl+"/", request, Ingredient.class);
    }

    public void removeIngredient(Long id){
        restTemplate.delete(ingredientUrl+"/"+id);
    }

    public void updateIngredient(Long id, Ingredient ingredient){
        HttpEntity<Ingredient> request = new HttpEntity<>(ingredient);
        restTemplate.put(ingredientUrl + "/"+id, request, Ingredient.class);
    }
}

