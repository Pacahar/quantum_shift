package com.example.task.controllers;

import lombok.AllArgsConstructor;
import com.example.task.dto.UserDTO;
import com.example.task.entity.AppUser;
import com.example.task.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostmanRegistrationController {

    private final UserService service;

    @RequestMapping(value = "/pregistration", method = RequestMethod.GET)
    public ResponseEntity<List<AppUser>> readAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/pregistration", method = RequestMethod.POST)
    public ResponseEntity<AppUser> create(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(service.addUser(dto), HttpStatus.OK);
    }

    @RequestMapping(value = "/pregistration", method = RequestMethod.PUT)
    public ResponseEntity<AppUser> update(@RequestBody AppUser user) {
        return new ResponseEntity<>(service.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/pregistration/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }

}
