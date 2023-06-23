package TestApp.controllers;

import TestApp.models.Student;
import TestApp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService ss;

    @PostMapping("")
    public ResponseEntity addStudent(@RequestBody final @NotNull Student s) {
        return ss.addStudent(s);
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return ss.getAll();
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updateStudent(@PathVariable final @NotNull Integer id, @RequestBody final @NotNull Student s) {
        return ss.updateStudent(id, s);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity deleteStudent(@PathVariable final @NotNull Integer id) {
        return ss.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable final @NotNull Integer id) {
        return ss.getStudent(id);
    }
}