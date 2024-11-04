package com.ks.scheduler.controller;


import com.ks.scheduler.entity.User;
import com.ks.scheduler.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    User newUser(@RequestBody User newUser) {
        return userService.newUser ( newUser );
    }

    @GetMapping("/getUser/{userId}")
    User getUser(@PathVariable int userId) {
        Optional<User> user = userService.findById ( userId );
        return user.orElseGet ( User::new );
    }

}
