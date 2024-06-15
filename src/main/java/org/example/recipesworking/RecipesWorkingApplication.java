package org.example.recipesworking;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
@Slf4j
public class RecipesWorkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipesWorkingApplication.class, args);
        log.info("Aplikace běží na adrese: http://localhost:8080/");
    }

}
