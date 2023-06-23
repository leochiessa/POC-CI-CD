package TestApp.services;

import TestApp.models.Student;
import TestApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@Service
public class StudentService {

    @Autowired
    public StudentService(StudentRepository sr) {
        this.sr = sr;
    }

    private final StudentRepository sr;

    public ResponseEntity addStudent(Student s) {
        try {
            sr.save(s);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public List<Student> getAll() {
        return sr.findAll();
    }

    public ResponseEntity updateStudent(Integer id, Student s) {
        try {
            Student st = sr.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "estudiante no encontrado"));
            st.setDni(s.getDni());
            st.setLastName(s.getLastName());
            st.setFirstName(s.getFirstName());
            st.setEmail(s.getEmail());
            sr.save(st);
            return ResponseEntity.status(OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity deleteStudent(Integer id) {
        try {
            sr.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public Student getStudent(Integer id) {
        return sr.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "estudiante no encontrado"));
    }
}