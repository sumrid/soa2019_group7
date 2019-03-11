package com.example.pos.controller;

import com.example.pos.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    public List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("1", "Leanne Graham", "Bret", "Sincere@april.biz", "7/65 Bangkok 10170", "manager"),
            new Employee("2", "Leanne Graham", "Bret", "Sincere@april.biz", "7/65 Bangkok 10170", "employee")
    ));

    // get employee list
    public List<Employee> getEmployeeList(){
        return employees;
    }

    // get an employee
    public Employee getEmployee(String id){
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().get();
    }

    // add new employee
    public void addEmployee(Employee newEmployee){
        employees.add(newEmployee);
    }
}