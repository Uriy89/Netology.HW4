package homework4.task_03;

import homework4.Employee;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void mainShouldThrowRuntimeExceptionWhenListIsNull() {
        List<Employee> list = null;
        Assertions.assertThrows(RuntimeException.class, () -> {
            for (Employee e : list) System.out.println(e);
        });
    }

}