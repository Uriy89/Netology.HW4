package homework4.task_01;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import homework4.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class MainTest {

    @Test
    void parseCSVThrowIOExceptionWhenFileNotFound() {
        Assertions.assertThrows(IOException.class, () -> {
            CSVReader csvReader = new CSVReader(new FileReader("test.csv"));
        });
    }

    @Test
    void parseCSVThrowRuntimeExceptionWhenConversionToLongFailed() throws FileNotFoundException {
        CSVReader csvReader = new CSVReader(new FileReader("data.csv"));
        String[] arr = {"id", "firstName", "lastName", "country", "age"};
        ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Employee.class);
        strategy.setColumnMapping(arr);
        CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
                .withMappingStrategy(strategy)
                .build();
        Assertions.assertThrows(RuntimeException.class, () -> {
            Employee employee = (Employee) csv.parse();
        });
    }

}