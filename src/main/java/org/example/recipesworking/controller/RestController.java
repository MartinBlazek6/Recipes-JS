package org.example.recipesworking.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.recipesworking.exceptions.ArticleGramsOutOfBoundsException;
import org.example.recipesworking.exceptions.ArticleNotFoundException;
import org.example.recipesworking.model.Article;
import org.example.recipesworking.model.dto.ArticleDto;
import org.example.recipesworking.model.rcord.ArticleRecord;
import org.example.recipesworking.service.ArticleService;
import org.example.recipesworking.service.implementation.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
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
    public ResponseEntity<String> calories(@RequestBody HashMap<Long, Integer> meal) {

        Integer calories = foodService.getCaloriesFromMeal(meal);

        return new ResponseEntity<>(calories / 1000 + " kcal", HttpStatus.OK);
    }

    @PostMapping("/eatMeat")
    public ResponseEntity<String> eatMeat(@RequestBody HashMap<Long, Integer> meal) {
        Integer calories = 0;
        try {
            calories = foodService.eatMealAndUpdateStorage(meal);
        } catch (ArticleGramsOutOfBoundsException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(calories + " cal", HttpStatus.OK);
    }


    @DeleteMapping("/deleteArticle")
    public ResponseEntity<String> deleteArticle(@RequestParam Long articleId) {
        try {
            articleService.deleteArticle(articleId);
        } catch (ArticleNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articleList = articleService.getAllArticles();

        return new ResponseEntity<>(articleList, HttpStatus.OK);
    }

}
