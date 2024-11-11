package com.ks.scheduler.controller;


import com.ks.scheduler.entity.User;
import com.ks.scheduler.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserWebController {

    @Autowired
    UserService userService;

    // Display the user form and list of users
    @GetMapping("/users")
    public ModelAndView showUserList() {
        ModelAndView mav = new ModelAndView("list-users");
        List<User> list = userService.findAll();
        mav.addObject("users", list);
        return mav;
    }

    @GetMapping("/addUserForm")
    public ModelAndView addUserForm() {
        ModelAndView mav = new ModelAndView("add-user-form");
        User newUser = new User();
        mav.addObject("user", newUser);
        return mav;
    }

    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam int userId) {
        ModelAndView mav = new ModelAndView("add-user-form");
        User user = userService.findById(userId).get();
        mav.addObject("user", user);
        return mav;
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam int userId) {
        userService.deleteById(userId);
        return "redirect:/users";
    }
}
