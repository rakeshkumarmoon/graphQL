package com.moon.practise.graphql.controller;

import com.moon.practise.graphql.dao.DepartmentDao;
import com.moon.practise.graphql.dao.EmployeeDao;
import com.moon.practise.graphql.dto.Department;
import com.moon.practise.graphql.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class EmployeeController {

    private EmployeeDao employeeDao;

     private DepartmentDao departmentDao;

    public EmployeeController(EmployeeDao employeeDao, DepartmentDao departmentDao) {
        this.employeeDao = employeeDao;
        this.departmentDao = departmentDao;
    }

    @QueryMapping
    public Collection<Employee> employees(){
        return employeeDao.getEmployees();
    }

    @SchemaMapping
    public Department department(Employee employee){
        return departmentDao.getDepartmentById(employee.departmentId());
    }
}
