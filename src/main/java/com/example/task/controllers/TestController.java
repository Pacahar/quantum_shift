package com.example.task.controllers;

import com.example.task.dto.SectionDTO;
import com.example.task.entity.AppUser;
import com.example.task.entity.Section;
import com.example.task.service.SectionsService;
import com.example.task.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TestController {
    private final SectionsService sectionService;
    private final UserService userService;
    @RequestMapping(value="/postman", method= RequestMethod.POST)
    public ResponseEntity<Section> create(@RequestBody SectionDTO dto){
        return new ResponseEntity<>(sectionService.create(dto), HttpStatus.OK);
    }

    @RequestMapping(value = "/postman", method = RequestMethod.GET)
    public ResponseEntity<List<AppUser>> readAll() {
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }


}
