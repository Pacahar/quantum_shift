package com.example.task.controllers;

import com.example.task.entity.Section;
import com.example.task.service.SectionsService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {
    private final SectionsService sectionService;
    @GetMapping("/")
    public String main(Model model) {
        List<Section> sections = sectionService.readAll();
        model.addAttribute("sections", sections);
        return"index";
    }

    @GetMapping("/index.html")
    public String qwerty(Model model) {
        return"index.html";
    }
}
