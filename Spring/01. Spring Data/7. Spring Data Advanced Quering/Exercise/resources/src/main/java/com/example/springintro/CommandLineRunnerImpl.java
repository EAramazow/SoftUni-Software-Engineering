package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedData();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select exercise number from 1 to 11: ");
        int exerciseNumber = Integer.parseInt(scanner.nextLine());

        if (exerciseNumber < 0 || exerciseNumber > 11) {
            System.out.println("Wrong exercise number!");
        }

        switch (exerciseNumber) {
            case 1 -> p01_BooksTitlesByAgeRestriction();
            case 2 -> p02_GoldenBooks();
            case 3 -> p03_booksByPrice();
            case 4 -> p04_NotReleasedBooks();
            case 5 -> p05_BooksReleasedBeforeDate();
            case 6 -> p06_AuthorsSearch();
            case 7 -> p07_BooksSearch();
            case 8 -> p08_BookTitlesSearch();
            case 9 -> p09_CountBooks();
            case 10 -> p10_TotalBookCopies();
            case 11 -> p11_ReducedBook();
        }


    }

    private void p11_ReducedBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter a book name: ");
        String title = scanner.nextLine();
        BookSummary summary = this.bookService.getInformationForTitle(title);

        System.out.println(summary.getTitle() + " " + summary.getEditionType()
        + " " + summary.getAgeRestriction() + " " + summary.getPrice());
    }

    private void p10_TotalBookCopies() {
        this.authorService.getWithTotalCopies()
                .forEach(a -> System.out.println(a.getFirstName() + " " +
                        a.getLastName() + " - " +
                        a.getTotalCopies()));
    }

    private void p09_CountBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter a number: ");
        int length = Integer.parseInt(scanner.nextLine());
        int totalBooks = this.bookService.countBooksWithTitleLongerThan(length);
        System.out.printf("There are %d books with longer title than %d symbols%n",
                totalBooks, length);
    }

    private void p08_BookTitlesSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter a characters: ");
        String search = scanner.nextLine();
        this.bookService.findByAuthorLastNameStartsWith(search)
                .forEach(b -> System.out.printf("%s (%s %s)%n",
                        b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));
    }

    private void p07_BooksSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter a characters: ");
        String search = scanner.nextLine();
        this.bookService.findAllTitlesContaining(search)
                .forEach(System.out::println);

    }

    private void p06_AuthorsSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter a characters: ");
        String endsWith = scanner.nextLine();
        this.authorService.findByFirstNameEndingWith(endsWith)
                .stream().map(a -> a.getFirstName() + " " + a.getLastName())
                .forEach(System.out::println);
    }

    private void p05_BooksReleasedBeforeDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter a date in format 'dd-mm-yyyy': ");
        String date = scanner.nextLine();
        this.bookService.findBooksReleasedBefore(date)
                .forEach(b -> System.out.printf("%s %s %.2f%n",
                        b.getTitle(), b.getEditionType(), b.getPrice()));
    }

    private void p04_NotReleasedBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter a year: ");
        int releaseYear = Integer.parseInt(scanner.nextLine());
        this.bookService.findNotReleaseIn(releaseYear)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void p03_booksByPrice() {
        this.bookService.findAllWithPriceBetween(5, 40)
                .forEach(b -> System.out.println(b.getTitle() + " - " + b.getPrice()));

    }

    private void p02_GoldenBooks() {
        this.bookService.findAllTitlesByEditionAndCopies(EditionType.GOLD, 5000)
                .forEach(System.out::println);

    }

    private void p01_BooksTitlesByAgeRestriction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter a book title: ");
        String restriction = scanner.nextLine();

        this.bookService.findByAgeRestriction(restriction)
                .forEach(System.out::println);
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
