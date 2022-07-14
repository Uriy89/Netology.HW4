package homework4.task_03;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import homework4.Employee;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String json = readString("new_data.json");
        List<Employee> list = jsonToList(json);

        for (Employee e : list) System.out.println(e);
    }

    public static String readString(String fileName) {
        JSONParser parser = new JSONParser();
        String res = " ";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            Object obj = parser.parse(bufferedReader);
            res = obj.toString();
        } catch (IOException | ParseException e) {
                throw new RuntimeException(e);
        }
        return res;
    }

    public static List<Employee> jsonToList(String json) {
        JSONParser parser = new JSONParser();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        List<Employee> employees = new ArrayList<>();
        try {
            JSONArray array = (JSONArray) parser.parse(json);
            for (Object obj : array) {
                String content = obj.toString();
                Employee employee = gson.fromJson(content, Employee.class);
                employees.add(employee);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
