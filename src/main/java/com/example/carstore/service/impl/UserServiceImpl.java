package com.example.carstore.service.impl;

import com.example.carstore.domain.exception.ResourceNotFoundException;
import com.example.carstore.domain.entity.user.Role;
import com.example.carstore.domain.entity.user.User;
import com.example.carstore.repository.UserRepository;
import com.example.carstore.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User getByUuid(UUID uuid) {
        return repository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional
    public User update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    @Transactional
    public User create(User user) {
        if (repository.findByUsername(user.getUsername()).isPresent()){
            throw new IllegalStateException("User already exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = Set.of(Role.ROLE_USER);
        user.setRoles(roles);
        return repository.save(user);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }
}
