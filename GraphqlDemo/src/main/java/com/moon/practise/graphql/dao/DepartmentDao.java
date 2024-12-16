package com.moon.practise.graphql.dao;

import com.moon.practise.graphql.dto.Department;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class DepartmentDao {

    private final Map<String, Department> departmentMap = new HashMap<>();

    @PostConstruct
    public void init() {
        departmentMap.put("D-1", new Department("D-1", "DataWareHouse", "Handles historical data"));
        departmentMap.put("D-2", new Department("D-2", "IT", "Information technology"));
        departmentMap.put("D-3", new Department("D-3", "HR", "Human resource"));
        departmentMap.put("D-4", new Department("D-4", "Admin", "Administrative work"));
    }

    public Collection<Department> getDepartments() {
        return departmentMap.values();
    }

    public Department getDepartmentById(String id) {
        return departmentMap.get(id);
    }


}
