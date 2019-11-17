package com.codecool.ingredient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    String description;

    Integer amount;

    String ImageUrl;

   // @ManyToOne
    //@JsonIgnore
    //private Recipe recipe;



}

