package org.example.recipesworking.model;

import jakarta.persistence.OneToOne;

import java.util.HashMap;

public class Recipe {

    private Long id;
    private String name;
    private HashMap<Long,Integer> ingredients;
    private int serving;
    private Integer calories;
    private Integer caloriesPerServing;

    @OneToOne
    private Approach approach;
}
