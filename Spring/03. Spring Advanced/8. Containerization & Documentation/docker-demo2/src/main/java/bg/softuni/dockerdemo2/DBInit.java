package bg.softuni.dockerdemo2;

import bg.softuni.dockerdemo2.model.StudentEntity;
import bg.softuni.dockerdemo2.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public DBInit(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var pesho = new StudentEntity().setAge(44).setName("Pesho Petrov");
        var anna = new StudentEntity().setAge(55).setName("Anna Dimitrova");

        studentRepository.save(pesho);
        studentRepository.save(anna);
    }
}
