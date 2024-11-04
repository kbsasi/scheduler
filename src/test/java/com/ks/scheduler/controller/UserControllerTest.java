package com.ks.scheduler.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ks.scheduler.entity.User;
import com.ks.scheduler.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createUser_ShouldReturnCreatedUser() throws Exception {
        // Define a sample User object
        User sampleUser = new User("John", "Doe", "johndoe@example.com");

        // Mock the behavior of userService.newUser
        Mockito.when(userService.newUser(Mockito.any(User.class))).thenReturn(sampleUser);

        // Perform POST request with sampleUser as JSON
        mockMvc.perform(post("/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleUser))) // Convert sampleUser to JSON
                .andExpect(status().isOk()) // Expect 200 OK response
                .andExpect(jsonPath("$.firstName", is("John"))) // Check JSON field "firstName"
                .andExpect(jsonPath("$.lastName", is("Doe"))) // Check JSON field "lastName"
                .andExpect(jsonPath("$.email", is("johndoe@example.com"))); // Check JSON field "email"
    }

    @Test
    public void getUser_ShouldReturnUserOfId() throws Exception {
        // Define a sample User object
        User sampleUser = new User("John", "Doe", "johndoe@example.com");

        // Mock the behavior of userService.findById
        Mockito.when(userService.findById ( sampleUser.getId () )).thenReturn( Optional.of ( sampleUser ) );

        // Perform GET request with sampleUser as JSON
        mockMvc.perform(get("/getUser/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleUser))) // Convert sampleUser to JSON
                .andExpect(status().isOk()) // Expect 200 OK response
                .andExpect(jsonPath("$.firstName", is("John"))) // Check JSON field "firstName"
                .andExpect(jsonPath("$.lastName", is("Doe"))) // Check JSON field "lastName"
                .andExpect(jsonPath("$.email", is("johndoe@example.com"))); // Check JSON field "email"
    }
}