package com.anwar.gsondeserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Type;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@SpringBootApplication
public class GsondeserializationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GsondeserializationApplication.class, args);


//        System.out.println("Custom employee = "+getEmployee());
//        System.out.println("Custom employee list = "+getCustomEmployeeList());
//        System.out.println("Simple employee = "+getSimlpeEmployee());
//        System.out.println("Simple employee list = "+getSimpleEmployeeList());
//        System.out.println(getCustomEmployeeList2());
        getDataFromAPI();
    }

   static Employee getEmployee(){

        String jsonString = "{'id': 1001,"
                + "'firstName': 'Anwar',"
                + "'lastName': 'Hossain',"
                + "'email': 'anwarjavapro17@gmail.com', "
                + "'dob': 1990-01-01,"
                +"'addresses':[" +
                "{'houseNumber': '2001'," +
                "'street': '55'," +
                "'city': 'Dhaka'," +
                "'country': 'Bangladesh'" +
                "}]," +
                "'contact':{" +
                "'mobile':'01921534551'," +
                "'officePhone':'01921534551'," +
                "'housePhone':'01921534551'}}";

       Gson gson = new GsonBuilder()
                .registerTypeAdapter(Employee.class, new EmployeeDeserializer())
                .create();
       Employee employee = gson.fromJson(jsonString, Employee.class);
        return employee;
    }

    static Employee getSimlpeEmployee(){

        String jsonString = "{'id': 1001,"
                + "'firstName': 'Anwar',"
                + "'lastName': 'Hossain',"
                + "'email': 'anwarjavapro17@gmail.com', "
                + "'dob': 1990-01-01,"
                +"'addresses':[" +
                "{'houseNumber': '2001'," +
                "'street': '55'," +
                "'city': 'Dhaka'," +
                "'country': 'Bangladesh'" +
                "}]}";

              Gson gsonSimple = new Gson();
       Employee employee = gsonSimple.fromJson(jsonString, Employee.class);
//       System.out.println(employee);
        return employee;
    }

    static List<Employee> getSimpleEmployeeList(){
        String jsonStringList = "[{'id': 1001,"
                + "'firstName': 'Anwar',"
                + "'lastName': 'Hossain',"
                + "'email': 'anwarjavapro17@gmail.com', "
                + "'dob': 1990-01-01,"
                +"'addresses':[" +
                "{'houseNumber': '2001'," +
                "'street': '55'," +
                "'city': 'Dhaka'," +
                "'country': 'Bangladesh'" +
                "}]}]";

        Gson gsonSimple = new Gson();
        Type type = new TypeToken<List<Employee>>(){}.getType();
        List<Employee> employeeList = gsonSimple.fromJson(jsonStringList, type);
        return employeeList;
    }

    static List<Employee> getCustomEmployeeList(){

        String jsonString = "[{'id': 1001,"
                + "'firstName': 'Anwar',"
                + "'lastName': 'Hossain',"
                + "'email': 'anwarjavapro17@gmail.com', "
                + "'dob': 1990-01-01,"
                +"'addresses':[" +
                "{'houseNumber': '2001'," +
                "'street': '55'," +
                "'city': 'Dhaka'," +
                "'country': 'Bangladesh'" +
                "}]," +
                "'contact':{" +
                "'mobile':'01921534551'," +
                "'officePhone':'01921534551'," +
                "'housePhone':'01921534551'}}]";

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Employee.class, new EmployeeDeserializer())
                .create();
        Type type = new TypeToken<List<Employee>>(){}.getType();
        List<Employee> employeeList = gson.fromJson(jsonString, type);
        return employeeList;
    }

    static List<Employee> getCustomEmployeeList2(){

        String jsonString2 = "[{'id': 1001,"
                + "'firstName': 'Anwar',"
                + "'lastName': 'Hossain',"
                + "'email': 'anwarjavapro17@gmail.com', "
                + "'dob': 1990-01-01,"
                +"'addresses':[" +
                "{'houseNumber': '2001'," +
                "'street': '55'," +
                "'city': 'Dhaka'," +
                "'country': 'Bangladesh'" +
                "}]," +
                "'contact':{" +
                "'mobile':'01921534551'," +
                "'officePhone':'01921534551'," +
                "'housePhone':'01921534551'}}]";

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Employee.class, new EmployeeDeserializer())
                .create();
        Type type = new TypeToken<List<Employee>>(){}.getType();
        List<Employee> employeeList = gson.fromJson(jsonString2, type);
        return employeeList;
    }

    static void getDataFromAPI(){

        try {
            URL url = new URL("https://api.covid19api.com/summary");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                System.out.println(inline);

                //Close the scanner
                scanner.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
