package TestApp.controllers;

import TestApp.Application;
import TestApp.models.Student;
import TestApp.services.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StudentControllerTest {

    @Mock
    private StudentService ss;

    @InjectMocks
    private StudentController sc;



    @Test
    public void getAll() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(0, "12345678", "aaa", "bbb", "q@q"));
        studentList.add(new Student(1, "87654321", "ggg", "hhh", "w@w"));
        when(sc.getAll()).thenReturn("Hola getAll");
    }


}