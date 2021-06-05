package com.medmehdi.sarray;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class BookRepositoryTest {

    @Inject
    BookRepository repository;

    @Test
    void testCount() {
        repository.save(new Book("MicroServices" , 500)) ;

        Book book = repository.findBookByTitle("MicroServices"); 

        Assertions.assertNotNull(book);    

        Assertions.assertEquals(
            3, repository.count());
    } 

    

}