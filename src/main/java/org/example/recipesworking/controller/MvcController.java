package org.example.recipesworking.controller;

import lombok.RequiredArgsConstructor;
import org.example.recipesworking.model.Article;
import org.example.recipesworking.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MvcController {

   private final ArticleService articleService;


    @GetMapping
    public String landingPage(){
        return "index";
    }

    @PostMapping("/sendBasket")
    public String sendBasket(){
        Article article = new Article("banana", 50,5,3);

        return "redirect:/";
    }

    @GetMapping("/articlesMvc")
    public String getAllArticles(Model model) {
        List<Article> articleList = articleService.getAllArticles();
       model.addAttribute("articles",articleList);

        return "articles";
    }
}
