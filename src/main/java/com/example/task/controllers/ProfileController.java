package com.example.task.controllers;

import com.example.task.entity.AppUser;
import com.example.task.entity.Section;
import com.example.task.service.SectionsService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class ProfileController {
    private final SectionsService sectionService;
    @GetMapping("/profile")
    public String main(Model model, Principal principal){
        AppUser user = sectionService.getUserByPrincipal(principal);
        model.addAttribute("logged", user != null);


        model.addAttribute("username", user.getName());
        model.addAttribute("daysRemaining", user.getSubscription());
        model.addAttribute("daysOfFreezing", user.getFreezeDays());
        model.addAttribute("endDate", LocalDate.now().plusDays(user.getSubscription()));

        model.addAttribute("profile", true);
        List<Section> sections = user.getSections();
        model.addAttribute("sections", sections);

        return "profile.html";
    }
}
