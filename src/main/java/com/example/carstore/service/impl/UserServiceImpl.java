package com.example.carstore.service.impl;

import com.example.carstore.domain.user.User;
import com.example.carstore.repository.UserRepository;
import com.example.carstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User getByUuid(UUID uuid) {
        return repository.findById(uuid).orElseThrow();
    }

    @Override
    public User getByUsername(String username) {
        return repository.findByUsername(username).orElseThrow();
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }
}
