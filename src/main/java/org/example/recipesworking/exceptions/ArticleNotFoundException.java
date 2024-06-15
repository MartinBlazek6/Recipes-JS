package org.example.recipesworking.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
