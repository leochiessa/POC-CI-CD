package TestApp.controllers;

import TestApp.Application;
import TestApp.services.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        when(sc.getAll()).thenReturn("Hola getAll");
    }
}