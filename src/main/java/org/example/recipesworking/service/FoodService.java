package org.example.recipesworking.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface FoodService {

    Integer eatMealAndUpdateStorage(HashMap<Long, Integer> meal);

    Integer getCaloriesFromMeal(HashMap<Long, Integer> meal);
}
