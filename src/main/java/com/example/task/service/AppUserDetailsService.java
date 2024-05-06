package com.example.task.service;

import com.example.task.config.AppUserDetails;
import com.example.task.entity.AppUser;
import com.example.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = repository.findByName(username);
        return user.map(AppUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
    }
}
