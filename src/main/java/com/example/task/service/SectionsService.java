package com.example.task.service;

import com.example.task.dto.SectionDTO;
import com.example.task.entity.AppUser;
import com.example.task.repository.SectionsRepository;
import com.example.task.entity.Section;
import com.example.task.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@AllArgsConstructor
public class SectionsService {
    private final SectionsRepository sectionsRepository;
    private final UserRepository userRepository;

    public Section create(SectionDTO dto){
        Section section = Section.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .time(dto.getTime())
                .duration(dto.getDuration())
                .day(dto.getDay())
                .build();
        return sectionsRepository.save(section);
    }
    public List<Section> readAll(){
        return sectionsRepository.findAll();
    }

    public Section update(Section section){
        return sectionsRepository.save(section);
    }

    public void delete(Long id){
        sectionsRepository.deleteById(id);
    }

    public Section addToList(Section section, Principal principal){
        section.setUser(getUserByPrincipal(principal));
        return sectionsRepository.save(section);
    }

    public AppUser getUserByPrincipal(Principal principal){
        if (principal == null) return null;
        return userRepository.findByName(principal.getName()).get();
    }
}
