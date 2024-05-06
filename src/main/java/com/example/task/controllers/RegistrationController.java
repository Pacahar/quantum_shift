package com.example.task.controllers;

import com.example.task.dto.UserDTO;
import com.example.task.entity.AppUser;
import com.example.task.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<AppUser> create(@RequestParam String name, @RequestParam String password,
                                          @RequestParam Integer subscription, @RequestParam Integer freezeDays,
                                          Model model) {
        UserDTO dto = new UserDTO(name, password, subscription, freezeDays, "USER");
        return new ResponseEntity<>(userService.addUser(dto), HttpStatus.OK);
    }
}
