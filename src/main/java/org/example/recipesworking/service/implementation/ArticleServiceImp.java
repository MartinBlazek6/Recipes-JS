package org.example.recipesworking.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.recipesworking.model.Article;
import org.example.recipesworking.model.dto.ArticleDto;
import org.example.recipesworking.model.rcord.ArticleRecord;
import org.example.recipesworking.repository.ArticleRepository;
import org.example.recipesworking.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImp implements ArticleService {

    private final ArticleRepository articleRepository;


    @Override
    public List<Article> findAllByBasketId(Long baskedId) {
        return List.of();
    }

    @Override
    public Article createArticle(ArticleDto articleDto) {
        Article article = new Article(
                articleDto.getName(),
                articleDto.getAmountInGramPerArticle(),
                articleDto.getQuantity(),
                articleDto.getCaloriesPerGram());

        return articleRepository.save(article);
    }


    @Override
    public Article createArticle(ArticleRecord articleRecord) {
        Article article = new Article(
                articleRecord.name(),
                articleRecord.amountInGramPerArticle(),
                articleRecord.quantity(),
                articleRecord.caloriesPerGram());

        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }

    @Override
    public Article updateArticleGrams(Long articleId, Integer gramsToBeRemoved){
        Article article = articleRepository.getReferenceById(articleId);
        article.setAmountInGram(article.getAmountInGram() - gramsToBeRemoved);
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }
}
