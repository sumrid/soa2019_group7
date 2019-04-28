package com.project.user_service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.user_service.controller.UserController;
import com.project.user_service.model.Employee;
import com.project.user_service.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testCreateEmpSuccess() throws Exception{

        Employee user = new Employee(1L, "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                "7/65 Bangkok 10170",
                "manager");

        when(userService.addEmployee(any(Employee.class))).thenReturn(user);

        ResultActions result = mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(user)));

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("Leanne Graham")))
                .andExpect(jsonPath("$.username", is("Bret")))
                .andExpect(jsonPath("$.email", is("Sincere@april.biz")))
                .andExpect(jsonPath("$.address", is("7/65 Bangkok 10170")))
                .andExpect(jsonPath("$.role", is("manager")));

        verify(userService).addEmployee(any(Employee.class));
    }
}
