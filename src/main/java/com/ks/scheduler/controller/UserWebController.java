package com.ks.scheduler.controller;


import com.ks.scheduler.entity.User;
import com.ks.scheduler.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserWebController {

    @Autowired
    UserService userService;

    // Display the user form and list of users
    @GetMapping("/users")
    public String showUserFormAndList(Model model) {
        model.addAttribute("users", userService.findAll());

        // Check if a user object is already in the model (for update), else add a new User object
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }

        return "userListForm";
    }

    // Handle form submission for both add and update
    @PostMapping("/users")
    public String saveOrUpdateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    // Populate the form with an existing user for editing
    @GetMapping("/users/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        User existingUser = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", existingUser);
        return "redirect:/users";
    }

    // Delete user by ID
    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
