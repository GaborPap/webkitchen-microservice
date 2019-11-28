package com.codecool.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
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
    @Length(max = 2000)
    private String description;
    private String image;

    private Integer servings; //adagok száma
    @Length(max = 2000)
    private String directions; //elkészítés
}
