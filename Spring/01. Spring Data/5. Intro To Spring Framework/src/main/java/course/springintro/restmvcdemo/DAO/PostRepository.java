package course.springintro.restmvcdemo.DAO;
import course.springintro.restmvcdemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{

}
