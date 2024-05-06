package com.example.task.service;

import lombok.AllArgsConstructor;
import com.example.task.dto.UserDTO;
import com.example.task.entity.AppUser;
import com.example.task.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private PasswordEncoder passwordEncoder;

    public AppUser addUser(UserDTO dto) {
        AppUser user = AppUser.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .subscription(dto.getSubscription())
                .freezeDays(dto.getFreezeDays())
                .roles(dto.getRoles())
                .build();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setPassword(user.getPassword());
        return repository.save(user);
    }

    public List<AppUser> readAll() {
        return repository.findAll();
    }

    public AppUser update(AppUser user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
