package com.example.task.controllers;

import com.example.task.entity.AppUser;
import lombok.AllArgsConstructor;
import com.example.task.dto.SectionDTO;
import com.example.task.entity.Section;
import com.example.task.service.SectionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@AllArgsConstructor
public class AdminPanelController {

    private final SectionsService sectionService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model, Principal principal) {
        AppUser user = sectionService.getUserByPrincipal(principal);
        model.addAttribute("logged", user != null);

        List<Section> sections = sectionService.readAll();
        model.addAttribute("sections", sections);

        return "admin";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ResponseEntity<Section> create(@RequestParam String name, @RequestParam String description,
                                          @RequestParam String time, @RequestParam float duration,
                                          @RequestParam String day, Model model) {
        SectionDTO dto = new SectionDTO(name, description, time, duration, day);
        return new ResponseEntity<>(sectionService.create(dto), HttpStatus.OK);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.DELETE)
    public void delete(@RequestParam Long id, Model model){
        sectionService.delete(id);
    }
}
