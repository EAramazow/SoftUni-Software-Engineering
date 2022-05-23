package springdataintroexercise.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springdataintroexercise.entities.Author;
import springdataintroexercise.entities.Book;
import springdataintroexercise.services.AuthorService;
import springdataintroexercise.services.BookService;
import springdataintroexercise.services.CategoryService;

import java.util.List;


@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();


        // Ex 1
        List<Book> books = this.bookService.getAllBooksAfter2000();

        // Ex 3

        this.authorService.findAllAuthorsByCountOfBooks()
                .forEach(author -> {
                    System.out.printf("%s %s %d%n", author.getFirstName(), author.getLastName(), author.getBooks().size());
                });


    }
}
