package org.example.recipesworking.service;

import org.example.recipesworking.model.Article;
import org.example.recipesworking.model.dto.ArticleDto;
import org.example.recipesworking.model.rcord.ArticleRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    List<Article> findAllByBasketId(Long baskedId);

    Article createArticle(ArticleDto articleDto);

    Article createArticle(ArticleRecord articleRecord);

    void deleteArticle(Long articleId);

    Article updateArticleGrams(Long articleId, Integer gramsToBeRemoved);
}
