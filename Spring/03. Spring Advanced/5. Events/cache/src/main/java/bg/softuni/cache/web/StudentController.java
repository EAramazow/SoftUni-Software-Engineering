package bg.softuni.cache.web;

import bg.softuni.cache.model.StudentDTO;
import bg.softuni.cache.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/students")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/search")
    public ResponseEntity<StudentDTO> getStudentByName(@RequestParam("name") String name){
        var student = studentService.getStudentByName(name);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(student);
    }

    @GetMapping("/evict")
    public ResponseEntity<StudentDTO> evict() {
        studentService.refresh();

        return ResponseEntity.noContent().build();
    }

}
