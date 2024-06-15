package org.example.recipesworking.repository;

import org.example.recipesworking.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findByNameAndCaloriesPerGram(String name, int caloriesPerGram);
}
