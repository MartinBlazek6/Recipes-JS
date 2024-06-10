package org.example.recipesworking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ArticleDto {
    private String name;
    private int amountInGramPerArticle;
    private int quantity;
    private int caloriesPerGram;
}
