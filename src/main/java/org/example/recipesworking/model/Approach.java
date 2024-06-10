package org.example.recipesworking.model;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Approach {
    @Id
    private Long id;


    @OneToOne
    private Recipe recipe;
}
