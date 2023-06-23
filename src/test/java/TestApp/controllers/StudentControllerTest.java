package TestApp.controllers;

import TestApp.Application;
import TestApp.models.Student;
import TestApp.services.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StudentControllerTest {

    @Mock
    private StudentService ss;

    @InjectMocks
    private StudentController sc;

    @Test
    public void addStudent() {
        Student s = new Student(0, "12345678", "aaa", "bbb", "q@q");
        when(sc.addStudent(s)).thenReturn(ResponseEntity.status(CREATED).build());
        ResponseEntity response = sc.addStudent(s);
        assertEquals(response.getStatusCode(), CREATED);
    }

    @Test
    public void getAll() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(0, "12345678", "aaa", "bbb", "q@q"));
        studentList.add(new Student(1, "87654321", "ggg", "hhh", "w@w"));
        when(sc.getAll()).thenReturn(studentList);
        List<Student> sl = sc.getAll();
        assertEquals(((List<Student>) sl).size(), studentList.size());
    }

    @Test
    public void updateStudent() {
        Student s = new Student(0, "12345678", "aaa", "bbb", "q@q");
        when(sc.updateStudent(0, s)).thenReturn(ResponseEntity.status(OK).build());
        ResponseEntity response = sc.updateStudent(0, s);
        assertEquals(response.getStatusCode(), OK);
    }

    @Test
    public void deleteStudent() {
        when(sc.deleteStudent(0)).thenReturn(ResponseEntity.status(OK).build());
        ResponseEntity response = sc.deleteStudent(0);
        assertEquals(response.getStatusCode(), OK);
    }

    @Test
    public void getStudent() {
        Student s = new Student(0, "12345678", "aaa", "bbb", "q@q");
        when(sc.getStudent(0)).thenReturn(s);
        Student st = sc.getStudent(0);
        assertEquals(st.getClass(), Student.class);
    }
}