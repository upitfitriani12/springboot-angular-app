package com.upit.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping
    public String homeController() {
        return "Welcome app code with fit";
    }

}