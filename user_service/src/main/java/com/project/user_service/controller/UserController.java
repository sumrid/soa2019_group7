package com.project.user_service.controller;
import com.project.user_service.model.Employee;
import com.project.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // get employee list
    @GetMapping("/employee")
    public  List<Employee> getEmployeeList(){
        return userService.getEmployeeList();
    }

    // get an employee
    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable long id) {
        Optional<Employee> employee = userService.getEmployee(id);
        if(!employee.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    //add employee
    @PostMapping("/employee")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee newEmployee) {
        Employee employee = (Employee) userService.addEmployee(newEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    //edit employee
    @PutMapping("/employee/{id}")
    public ResponseEntity<?> editEmployee(@PathVariable long id, @Valid @RequestBody Employee cur_employee) {
        Optional<Employee> employee = userService.editEmployee(id, cur_employee);
        if(!employee.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    //delete employee
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id) {
        if(!userService.deleteEmployee(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
