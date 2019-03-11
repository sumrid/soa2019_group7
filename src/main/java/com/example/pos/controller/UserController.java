package com.example.pos.controller;
import com.example.pos.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // get employee list
    @RequestMapping("/employee1/{id}")
    public List<Employee> getEmployeeList(@PathVariable  String id){
        return userService.getEmployeeList();
    }

    // get an employee
    @RequestMapping("/employee2/{id}")
    public Employee getArticle(@PathVariable  String id){
        return userService.getEmployee(id) ;
    }

    //add employee
    @PostMapping(value = "")
    public List<Employee> addEmployee(@RequestBody Employee newEmployee){
        userService.addEmployee(newEmployee);
        return userService.getEmployeeList();
    }

}
