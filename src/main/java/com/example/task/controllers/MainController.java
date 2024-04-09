package com.example.task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model) {
        return"index.html";
    }

    @GetMapping("/index.html")
    public String qwerty(Model model) {
        return"index.html";
    }
}
