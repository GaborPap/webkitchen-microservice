package com.codecool.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    private Map<Integer, Integer> ingredients;

    @NotNull
    private String name;
    private String description;
    private String image;
    private Integer servings; //adagok száma
    private String directions; //elkészítés
}
