package com.example.task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("logged", false);
        return"index";
    }

    @GetMapping("/logged")
    public String indexLogged(Model model){
        model.addAttribute("logged", true);
        return "index";
    }

    @GetMapping("/admin")
    public String adminPanel(Model model){
        return "admin";
    }
}
