package com.medmehdi.sarray;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Controller("/books")
class BookController {

    private final BookRepository repository; 

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @Get("/")
    List<Book> list(){
      return repository.findAll();
    }

    @Get("/{title}")
    Book findByTitle(String title){
      return repository.findBookByTitle(title);
    }

    @Post("/")
    Book save(@NotBlank String title, @Min(50) int pages)
    {
        return repository.save(new Book(title,pages)) ;
    }
}