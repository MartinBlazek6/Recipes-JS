package org.example.recipesworking.service.implementation;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface FoodService {

    Integer caloriesFromMeal(HashMap<Long, Integer> meal);
}
