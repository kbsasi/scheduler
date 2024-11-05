package com.ks.scheduler.controller;


import com.ks.scheduler.entity.User;
import com.ks.scheduler.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserWebController {

    @Autowired
    UserService userService;

    @PostMapping("/makeUser")
    public String createUser(@ModelAttribute User user, Model model) {
        User createdUser = userService.newUser(user);
        model.addAttribute("createdUser", createdUser);
        return "userSuccess";
    }

    @GetMapping("/userForm")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }
}
