package com.ks.scheduler.controller;

import com.ks.scheduler.entity.User;
import com.ks.scheduler.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserWebController.class)
class UserWebControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testShowUserList() throws Exception {
        // Arrange: Set up mock data
        User user1 = new User("Alice", "M", "alice.m@example.com");
        User user2 = new User("Bob", "N", "bob.n@example.com");
        List<User> userList = Arrays.asList(user1, user2);

        when(userService.findAll()).thenReturn(userList);

        // Act & Assert
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(view().name("list-users"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", userList));
    }
}