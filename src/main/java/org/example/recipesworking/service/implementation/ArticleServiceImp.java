package org.example.recipesworking.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.recipesworking.exceptions.ArticleGramsOutOfBoundsException;
import org.example.recipesworking.exceptions.ArticleNotFoundException;
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
        return List.of(); // todo opravit
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
        boolean articleIsPresent = articleRepository.findByNameAndCaloriesPerGram(articleRecord.name(), articleRecord.caloriesPerGram()).isPresent();

        if (articleIsPresent){
            Article article = articleRepository.findByNameAndCaloriesPerGram(articleRecord.name(), articleRecord.caloriesPerGram()).get();
            return raiseQuantityOfArticleGrams(article, articleRecord.amountInGramPerArticle() * articleRecord.quantity());
        }
            Article article = new Article(
                    articleRecord.name(),
                    articleRecord.amountInGramPerArticle(),
                    articleRecord.quantity(),
                    articleRecord.caloriesPerGram());

            return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long articleId) {
        boolean articleIsPresent = articleRepository.findById(articleId).isPresent();
        if (articleIsPresent){
            articleRepository.deleteById(articleId);
        }
        throw new ArticleNotFoundException(String.format("Article with id: %s was not found", articleId));
    }

    @Override
    public Article removeArticleGrams(Long articleId, Integer gramsToBeRemoved) {
        Article article = articleRepository.getReferenceById(articleId);
        int articleGrams = article.getAmountInGram();
        if (gramsToBeRemoved <= articleGrams) {
            article.setAmountInGram(article.getAmountInGram() - gramsToBeRemoved);
            return articleRepository.save(article);
        }
        throw new ArticleGramsOutOfBoundsException(String.format("Actual grams %d but to be removed was %d", article.getAmountInGram(), gramsToBeRemoved));
    }

    @Override
    public Article raiseQuantityOfArticleGrams(Article article, Integer gramsToBeRaised) {
            article.setAmountInGram(article.getAmountInGram() + gramsToBeRaised);
            return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
