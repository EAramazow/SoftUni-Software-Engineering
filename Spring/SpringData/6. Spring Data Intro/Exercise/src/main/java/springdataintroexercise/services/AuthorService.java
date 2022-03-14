package springdataintroexercise.services;

import springdataintroexercise.entities.Author;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public interface AuthorService {
    void seedAuthors() throws IOException;

    int getAllAuthorsCount();

    Author findAuthorById(Long id);

    List<Author> findAllAuthorsByCountOfBooks();



}
