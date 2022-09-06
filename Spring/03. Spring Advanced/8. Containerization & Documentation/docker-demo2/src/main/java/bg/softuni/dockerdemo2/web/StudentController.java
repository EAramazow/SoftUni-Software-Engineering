package bg.softuni.dockerdemo2.web;

import bg.softuni.dockerdemo2.model.StudentDTO;
import bg.softuni.dockerdemo2.model.StudentEntity;
import bg.softuni.dockerdemo2.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/all")
    public List<StudentDTO> all() {

        return studentRepository.findAll()
                .stream()
                .map(this::map)
                .toList();

    }

    private StudentDTO map(StudentEntity entity) {
       return new StudentDTO().setAge(entity.getAge())
                .setName(entity.getName());
    }
}
