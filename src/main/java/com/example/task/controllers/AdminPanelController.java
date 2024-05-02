package com.example.task.controllers;

import com.example.task.dto.SectionDTO;
import com.example.task.entity.Section;
import com.example.task.service.SectionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class AdminPanelController {

    private final SectionsService sectionService;

    @GetMapping("/admin")
    public static String admin(String[] args) {
        return "admin.html";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ResponseEntity<Section> create(@RequestParam String name, @RequestParam String description,
                                          @RequestParam String time, @RequestParam float duration,
                                          @RequestParam String day, Model model) {
        SectionDTO dto = new SectionDTO(name, description, time, duration, day);
        return new ResponseEntity<>(sectionService.create(dto), HttpStatus.OK);
    }
}
