package com.example.pos.User;

import com.example.pos.api.user.model.Employee;
import com.example.pos.api.user.repository.UserRepository;
import com.example.pos.api.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Test
    public void getEmployeeTest() {
        // test get employee list
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(1L, "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                "7/65 Bangkok 10170",
                "manager"));

        when(userRepository.findAll())
                .thenReturn(employeeList);

        when(userRepository.findById(1L))
                .thenReturn(Optional.ofNullable(employeeList.get(0)));

        UserService service = new UserService(userRepository);
        assertEquals(employeeList, service.getEmployeeList());
        assertEquals(employeeList.get(0), service.getEmployee(1).get());
    }

    @Test
    public void addEmployeeTest(){
        // test add employee
        Employee nullEmployee = new Employee(null, "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                "7/65 Bangkok 10170",
                "manager");
        Employee newEmployee = new Employee(1L, "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                "7/65 Bangkok 10170",
                "manager");
        when(userRepository.save(nullEmployee))
                .thenReturn(newEmployee);

        UserService service = new UserService(userRepository);
        assertEquals(newEmployee, service.addEmployee(nullEmployee));
    }

    @Test
    public void editEmployeeTest(){
        // test edit employee
        Employee oldEmployee = new Employee(1L, "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                "7/65 Bangkok 10170",
                "manager");
        Employee editEmployee = new Employee(1L, "Sedah Endless",
                "Bret",
                "Sincere@april.biz",
                "7/65 Bangkok 10170",
                "manager");
        when(userRepository.findById(1L))
                .thenReturn(Optional.of(oldEmployee));
        when(userRepository.save(editEmployee))
                .thenReturn(editEmployee);


        UserService service = new UserService(userRepository);
        assertEquals(editEmployee, service.editEmployee(1L, editEmployee).get());
    }
    @Test
    public void deleteEmployeeTest(){
        // test delete employee
        Employee employee = new Employee(1L, "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                "7/65 Bangkok 10170",
                "manager");

        UserService service = new UserService(userRepository);
        service.deleteEmployee(1L);

        verify(userRepository,times(1)).deleteById(1L);

    }


}