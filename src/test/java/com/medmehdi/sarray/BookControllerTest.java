package com.medmehdi.sarray;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class BookControllerTest {

    @Test
    void testListBook(BookClient client) {
      List<Book> books = client.list();
       Assertions.assertEquals(2, books.size());
    }

    @Client("/books")
    interface BookClient {
        
        @Get("/")
        List<Book> list();
        
    }
} 