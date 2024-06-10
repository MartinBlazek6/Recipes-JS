package org.example.recipesworking.controller;

import org.example.recipesworking.model.Article;
import org.example.recipesworking.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MvcController {


    @GetMapping
    public String landingPage(){
        return "index";
    }

    @PostMapping("/sendBasket")
    public String sendBasket(){
        Article article = new Article("banana", 50,5,3);

        return "redirect:/";
    }
}
