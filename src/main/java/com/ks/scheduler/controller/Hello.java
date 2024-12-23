package com.ks.scheduler.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Hello {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Sasi") String name) {
        return String.format("Hello %s!", name);
    }
}
