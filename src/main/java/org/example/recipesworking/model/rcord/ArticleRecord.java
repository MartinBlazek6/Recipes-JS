package org.example.recipesworking.model.rcord;

public record ArticleRecord(
        String name,
        int amountInGramPerArticle,
        int quantity,
        int caloriesPerGram) {
}
