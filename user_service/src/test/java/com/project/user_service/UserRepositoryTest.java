package com.example.pos.User;

import com.example.pos.api.user.model.Employee;
import com.example.pos.api.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void success_find_by_name_with_leanne() {
        // Initial data in database
        Employee Leanne = new Employee(
                null,
                "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                "7/65 Bangkok 10170",
                "manager");
        userRepository.save(Leanne);

        // Find by name
        Optional<Employee> someUser = userRepository.findByname("Leanne Graham");

        // Assert
        assertEquals("Leanne Graham", someUser.get().getName());
        assertEquals("Bret", someUser.get().getUsername());
        assertEquals("Sincere@april.biz", someUser.get().getEmail());
        assertEquals("7/65 Bangkok 10170", someUser.get().getAddress());
        assertEquals("manager", someUser.get().getRole());
    }

}
