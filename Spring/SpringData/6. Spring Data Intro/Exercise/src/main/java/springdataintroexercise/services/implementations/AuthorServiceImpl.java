package springdataintroexercise.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintroexercise.constants.GlobalConstants;
import springdataintroexercise.entities.Author;
import springdataintroexercise.repositories.AuthorRepository;
import springdataintroexercise.services.AuthorService;
import springdataintroexercise.utils.FileUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;


    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(GlobalConstants.AUTHORS_FILE_PATH);

        Arrays.stream(fileContent).forEach(row -> {
            String[] parameters = row.split("\\s+");
            Author author = new Author(parameters[0], parameters[1]);

            this.authorRepository.saveAndFlush(author);
        });
    }

    @Override
    public int getAllAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.getById(id);
    }

    @Override
    public List<Author> findAllAuthorsByCountOfBooks() {
        return this.authorRepository.findAuthorByCountOfBook();
    }



}
