package com.example.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String password;
    private Integer subscription;
    private Integer freezeDays;
    private String roles;
}