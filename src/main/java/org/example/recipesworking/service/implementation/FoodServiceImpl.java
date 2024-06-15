package org.example.recipesworking.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.recipesworking.model.Article;
import org.example.recipesworking.repository.ArticleRepository;
import org.example.recipesworking.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @Override
    public Integer eatMealAndUpdateStorage(HashMap<Long, Integer> meal){
        Integer calories = 0;

      for (var m : meal.entrySet()) {
          Long articleId = m.getKey();
          Integer grams = m.getValue();

          calories += getCaloriesFromArticle(articleId,grams);
      }
      deleteEatenFood(meal);
        return calories;

    }

    @Override
    public Integer getCaloriesFromMeal(HashMap<Long, Integer> meal){
        Integer calories = 0;

        for (var m : meal.entrySet()) {
            Long articleId = m.getKey();
            Integer grams = m.getValue();

            calories += getCaloriesFromArticle(articleId,grams);
        }
        return calories;

    }

    private void deleteEatenFood(HashMap<Long, Integer> meal){
        for (var m : meal.entrySet()) {
            Long articleId = m.getKey();
            Integer grams = m.getValue();
            articleService.updateArticleGrams(articleId,grams);
        }

    }

    private Integer getCaloriesFromArticle(Long articleId, Integer grams){
        Article article = articleRepository.getReferenceById(articleId);

        return article.getCalories(grams);
    }

}
