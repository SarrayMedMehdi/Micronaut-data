package com.medmehdi.sarray;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;

@JdbcRepository(dialect=Dialect.MYSQL)
interface BookRepository extends CrudRepository<Book, Long> {

    public Book findBookByTitle(String title); 

    @Override
    public List <Book> findAll();

}   