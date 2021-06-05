package com.medmehdi.sarray;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import java.util.Arrays;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@OpenAPIDefinition(
    info = @Info(
            title = "smehdi",
            version = "0.0"
    )
)

@Singleton
public class Application {

    BookRepository repository ; 

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

     Application(BookRepository repository) {
        this.repository = repository;
    }

    @EventListener
    @Transactional
    void init(StartupEvent event){
        Book books[] = new Book[]{new Book("The sand",1000)
                                ,new Book("l'alchimiste",300)} ;

        repository.saveAll(Arrays.asList(books));
    }
}
