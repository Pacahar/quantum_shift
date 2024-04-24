package com.example.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SectionDTO {
    private String name;
    private String description;
    private String time;
    private float duration;
    private String day;
}
