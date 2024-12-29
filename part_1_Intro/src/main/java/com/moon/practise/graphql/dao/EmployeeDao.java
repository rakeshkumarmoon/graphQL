package com.moon.practise.graphql.dao;

import com.moon.practise.graphql.dto.Employee;
import com.moon.practise.graphql.dto.Gender;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeDao {
    private final Map<String, Employee> employeeMap=new HashMap<>();

    @PostConstruct
    public void init(){
        employeeMap.put("E-1",new Employee("E-1","Aman","aman@gmail.com", Gender.MALE,"D-1"));
        employeeMap.put("E-2",new Employee("E-2","Sohan","sohan123@gmail.com", Gender.MALE,"D-2"));
        employeeMap.put("E-3",new Employee("E-3","Arun","arun@gmail.com", Gender.MALE,"D-1"));
        employeeMap.put("E-4",new Employee("E-4","Divya","divya@gmail.com", Gender.FEMALE,"D-3"));
        employeeMap.put("E-5",new Employee("E-5","Mac","mac@gmail.com", Gender.MALE,"D-4"));
        employeeMap.put("E-6",new Employee("E-6","Tom",null, Gender.MALE,null));

    }

    public Collection<Employee> getEmployees() {
        return employeeMap.values();
    }

    public Employee getEmployeeById(String id) {
        return employeeMap.get(id);
    }
}
