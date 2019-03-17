package com.example.pos.api.user.service;

import com.example.pos.api.user.model.Employee;
import com.example.pos.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get employee list
    public List<Employee> getEmployeeList(){
        return (List<Employee>) userRepository.findAll();
    }

    // get an employee
    public Optional<Employee> getEmployee(long id){
        return userRepository.findById(id) ;
    }

    //add employee
    public Employee addEmployee(Employee newEmployee){
        newEmployee.setId(null);
        return userRepository.save(newEmployee);
    }

    //edit employee
    public Optional<Employee> editEmployee(Long id, Employee employee){
        Optional<Employee> employeeOptional = userRepository.findById(id);
        if(!employeeOptional.isPresent()){
            return employeeOptional;
        }
        employee.setId(id);
        return Optional.of(userRepository.save(employee));
    }

    //delete employee
    public boolean deleteEmployee(Long id){
        try {
            userRepository.deleteById(id);
            return true;

        } catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}