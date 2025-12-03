package com.example.modulo2.repository;

import java.util.Optional;

import com.example.modulo2.entities.User;

public interface UserRepository {
    User criar(User user);
    Optional<User> findById(String id);
}
