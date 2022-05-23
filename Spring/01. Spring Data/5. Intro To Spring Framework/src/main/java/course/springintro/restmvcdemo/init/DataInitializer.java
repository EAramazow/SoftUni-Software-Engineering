package course.springintro.restmvcdemo.init;

import course.springintro.restmvcdemo.DAO.PostRepository;
import course.springintro.restmvcdemo.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private PostRepository postRepo;


    @Override
    public void run(String... args) throws Exception {

        if (postRepo.count() == 0) {
            List.of(
                    new Post("New in Spring", "Spring Boot is fancy ...", "Emil",
                            Set.of("Spring", "java", "Spring Boot")),
                    new Post("Reactive Spring", "Web flux is here ...", "Emil",
                            Set.of("Spring", "java", "Spring Boot")),
                    new Post("Easy to test", "Spring Boot is fancy ...", "Emil",
                            Set.of("Spring", "java", "Spring Boot"))
            ).forEach(postRepo::save);
        }
    }
}
