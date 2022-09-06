package bg.softuni.books.web;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.service.BookService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }


    @Tag(name = "Get Book by ID", description = "Returns a book details by its ID")
    @Parameter(
            name = "id",
            description = "The ID of the book",
            required = true
    )
    @ApiResponse(
            responseCode = "200",
            description = "If the book was retrieved successfully"
    )
    @ApiResponse(
            responseCode = "404",
            description = "If the book was not found"
    )
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long bookId) {
        Optional<BookDTO> bookOpt = bookService.getBookById(bookId);

        if (bookOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(bookOpt.get());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BookDTO> deleteBookById(@PathVariable("id") Long bookId) {
        bookService.deleteBookById(bookId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO newBook,
                                              UriComponentsBuilder uriComponentsBuilder) {
        long newBookID = bookService.createBook(newBook);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/books/{id}")
                        .build(newBookID))
                .build();
    }

}
