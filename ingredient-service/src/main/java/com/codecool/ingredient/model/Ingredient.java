package com.codecool.ingredient.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Ingredient {

    @Id
    @GeneratedValue
    @JoinColumn
    private Long id;

    @NotNull
    private String name;

    @Enumerated
    private IngredientUnit unit;

    @Length(max = 2000)
    String description;

    String imageUrl;

}

