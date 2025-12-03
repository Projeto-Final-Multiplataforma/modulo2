package com.example.modulo2.repository;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.modulo2.entities.User;
import com.example.modulo2.repository.adapters.UserRepositoryAdapter;
import com.example.modulo2.repository.mysql.MySQLUserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final MySQLUserRepository mySQLUserRepository;
    private final PasswordEncoder passwordEncoder;
    public UserRepositoryImpl(
        MySQLUserRepository mySQLUserRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.mySQLUserRepository = mySQLUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User criar(User user) {
        return UserRepositoryAdapter.cast(
            mySQLUserRepository.save(UserRepositoryAdapter.cast(user, passwordEncoder))
        );
    }

    @Override
    public Optional<User> findById(String id) {

        return mySQLUserRepository.findById(id)
            .map(UserRepositoryAdapter::cast);
    }
    
}
