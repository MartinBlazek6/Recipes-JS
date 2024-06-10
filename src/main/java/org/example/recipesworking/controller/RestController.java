package org.example.recipesworking.controller;

import lombok.RequiredArgsConstructor;
import org.example.recipesworking.model.Article;
import org.example.recipesworking.model.dto.ArticleDto;
import org.example.recipesworking.model.rcord.ArticleRecord;
import org.example.recipesworking.service.ArticleService;
import org.example.recipesworking.service.implementation.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private final ArticleService articleService;
    private final FoodService foodService;


    @PostMapping("/createArticle")
    public ResponseEntity<Article> addArticle(@RequestBody ArticleDto articleDto) {
        Article createdArticle = articleService.createArticle(articleDto);

        return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
    }

    @PostMapping("/createArticleR")
    public ResponseEntity<Article> addArticle(@RequestBody ArticleRecord articleRecord) {
        Article createdArticle = articleService.createArticle(articleRecord);

        return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
    }

    @GetMapping("/mealCalories")
    public ResponseEntity<String> calories(@RequestBody HashMap<Long,Integer> meal) {

        Integer calories = foodService.caloriesFromMeal(meal);

        return new ResponseEntity<>(calories / 1000 + " kcal",HttpStatus.OK);
    }

    @PostMapping("/eatMeat")
    public ResponseEntity<String> eatMeat(@RequestBody HashMap<Long,Integer> meal) {

        Integer calories = foodService.caloriesFromMeal(meal);

        return new ResponseEntity<>(calories / 1000 + " kcal",HttpStatus.OK);
    }


    @DeleteMapping("/deleteArticle")
    public ResponseEntity<String> deleteArticle(@RequestParam Long articleId){
        articleService.deleteArticle(articleId);

        return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
    }
}
