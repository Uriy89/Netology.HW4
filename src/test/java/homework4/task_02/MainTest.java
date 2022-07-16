package homework4.task_02;

import homework4.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void mainShouldThrowRuntimeExceptionWhenListIsNull() {
        List<Employee> list = null;
        Assertions.assertThrows(RuntimeException.class, () -> {
           for (Employee e : list) System.out.println(e);
        });
    }

    @Test
    void mainTestEmployeeCreation() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Fox", "Malder", 32));
        assertEquals(1, list.size());
    }

    @Test
    void parseXMLShouldThrowIOExceptionWhenFileNotFound() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Assertions.assertThrows(IOException.class, () -> {
            Document document = builder.parse(new File("test.xml"));
        });
    }

}