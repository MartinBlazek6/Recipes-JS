package org.example.recipesworking.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.recipesworking.exceptions.ArticleNotFoundException;
import org.example.recipesworking.model.Article;
import org.example.recipesworking.model.dto.ArticleDto;
import org.example.recipesworking.model.rcord.ArticleRecord;
import org.example.recipesworking.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MvcController {

   private final ArticleService articleService;


    @GetMapping
    public String landingPage(){
        return "index";
    }


    @GetMapping("/articlesMvc")
    public String getAllArticles(Model model) {
        List<Article> articleList = articleService.getAllArticles();
       model.addAttribute("articles",articleList);

        return "articles";
    }

    @PostMapping("/deleteArticle")
    public String deleteArticle(@RequestParam Long articleId) {
        try {
            articleService.deleteArticle(articleId);
        } catch (ArticleNotFoundException e) {
            log.error(e.getMessage());
        }

        return "redirect:/articlesMvc";
    }

    @PostMapping("/createArticleR")
    public String addArticle(
            @RequestParam String name,
            @RequestParam int amountInGramPerArticle,
            @RequestParam int quantity,
            @RequestParam int caloriesPerGram) {
        ArticleRecord articleRecord = new ArticleRecord(name, amountInGramPerArticle, quantity, caloriesPerGram);
        articleService.createArticle(articleRecord);
        return "redirect:/articlesMvc";
    }


}
