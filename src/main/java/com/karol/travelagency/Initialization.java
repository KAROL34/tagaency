package com.karol.travelagency;

import com.karol.travelagency.security.model.Role;
import com.karol.travelagency.security.model.User;
import com.karol.travelagency.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
public class Initialization {
    private final UserRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${admin.password}")
    private String adminPassword;

    public Initialization(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    void initialize() {
        if (!usersRepository.checkIfNameExists("admin")) {
            var user = new User();
            user.setPassword(passwordEncoder.encode(adminPassword));
            user.setEmail("admin@admin.pl");
            user.setUsername("admin");

            user.setRole(Role.ADMIN);
            usersRepository.save(user);
        }
    }
}