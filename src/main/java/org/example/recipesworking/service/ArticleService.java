package org.example.recipesworking.service;

import org.example.recipesworking.model.Article;
import org.example.recipesworking.model.dto.ArticleDto;
import org.example.recipesworking.model.rcord.ArticleRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    /**
     * Retrieves all articles associated with a specific basket ID.
     *
     * @param basketId the ID of the basket
     * @return a list of articles associated with the specified basket ID
     */
    List<Article> findAllByBasketId(Long basketId);

    /**
     * Creates a new article based on the provided ArticleDto.
     *
     * @param articleDto the data transfer object containing the details of the article to be created
     * @return the created article
     */
    Article createArticle(ArticleDto articleDto);

    /**
     * Creates a new article based on the provided ArticleRecord.
     *
     * @param articleRecord the record containing the details of the article to be created
     * @return the created article
     */
    Article createArticle(ArticleRecord articleRecord);

    /**
     * Deletes an article by its ID.
     *
     * @param articleId the ID of the article to be deleted
     */
    void deleteArticle(Long articleId);

    /**
     * Updates the grams of an article by removing a specified amount.
     *
     * @param articleId       the ID of the article to be updated
     * @param gramsToBeRemoved the number of grams to be removed from the article
     * @return the updated article
     */
    Article updateArticleGrams(Long articleId, Integer gramsToBeRemoved);

    /**
     * Gets all articles from storage
     *
     * @return List of Articles from storage
     */
    List<Article> getAllArticles();
}
