package com.example.task.controllers;

import com.example.task.entity.AppUser;
import com.example.task.entity.Section;
import com.example.task.service.SectionsService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {
    private final SectionsService sectionService;
    @GetMapping("/")
    public String main(@RequestParam(value="sectionId", required = false) Long sectionId, Model model, Principal principal) {
        AppUser user = sectionService.getUserByPrincipal(principal);
        model.addAttribute("logged", user != null);
        model.addAttribute("profile", false);

        List<Section> sections = sectionService.readAll();
        model.addAttribute("sections", sections);

        if (sectionId != null & user != null) {
            Section section = findSectionById(sectionId, sections);
            sectionService.addToList(section, principal);
        }

        return"index";
    }

    public Section findSectionById(Long id, List<Section> list) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getId().equals(id))
                return list.get(i);
        }
        return null;
    }
}
