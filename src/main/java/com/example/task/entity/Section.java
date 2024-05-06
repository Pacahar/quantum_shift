package com.example.task.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private String time;
    private float duration;
    private String day;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn
    private AppUser user;
}
