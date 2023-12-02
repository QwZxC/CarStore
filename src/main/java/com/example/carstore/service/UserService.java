package com.example.carstore.service;

import com.example.carstore.domain.entity.user.User;

import java.util.UUID;

public interface UserService {
    User getByUuid(UUID uuid);

    User getByUsername(String username);

    User update(User user);

    User create(User user);

    void delete(UUID uuid);
}
