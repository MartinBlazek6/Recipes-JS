package org.example.recipesworking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Entity
@NoArgsConstructor
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    private String name;
    private int amountInGram;
    private int caloriesPerGram;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public int getCalories(int amountInGram) {
        return caloriesPerGram * amountInGram;
    }

    public void setAmountInGram(int amountInGram) {
        this.amountInGram = amountInGram;
    }

    public int getAmountInGram() {
        return amountInGram;
    }

    public Article(
            String name,
            int amountInGramPerArticle,
            int quantity,
            int caloriesPerGram) {
        this.name = name;
        this.amountInGram = amountInGramPerArticle * quantity;
        this.caloriesPerGram = caloriesPerGram;
    }
}
