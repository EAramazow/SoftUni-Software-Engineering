package springdataintroexercise.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintroexercise.constants.GlobalConstants;
import springdataintroexercise.entities.*;
import springdataintroexercise.repositories.BookRepository;
import springdataintroexercise.services.AuthorService;
import springdataintroexercise.services.BookService;
import springdataintroexercise.services.CategoryService;
import springdataintroexercise.utils.FileUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {

        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(GlobalConstants.BOOKS_FILE_PATH);

        Arrays.stream(fileContent).forEach(row -> {
            String[] parameters = row.split("\\s+");

            Author author = this.getRandomAuthor();

            EditionType editionType = EditionType.values()[Integer.parseInt(parameters[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(parameters[1], formatter);
            int copies = Integer.parseInt(parameters[2]);
            BigDecimal price = new BigDecimal(parameters[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(parameters[4])];
            String title = this.getTitle(parameters);
            Set<Category> categories = this.getRandomCategories();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);

        });

    }

    @Override
    public List<Book> getAllBooksAfter2000() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("31/12/2000", formatter);



        return bookRepository.findAllByReleaseDateAfter(releaseDate);
    }



    private Set<Category> getRandomCategories() {

        Set<Category> result = new HashSet<>();
        Random random = new Random();
        int bound = random.nextInt(3) + 1;

        for (int i = 1; i <= bound; i++) {
            int categoryId = random.nextInt(8) + 1;
            result.add(this.categoryService.getCategoryById((long) categoryId));
        }
        return result;
    }

    private String getTitle(String[] parameters) {

        StringBuilder builder = new StringBuilder();

        for (int i = 5; i < parameters.length; i++) {
            builder.append(parameters[i])
                    .append(" ");
        }
        System.out.println();
        return builder.toString().trim();
    }

    private Author getRandomAuthor() {

        Random random = new Random();
        int randomId = random.nextInt(this.authorService.getAllAuthorsCount()) + 1;

        return this.authorService.findAuthorById((long) randomId);
    }
}
