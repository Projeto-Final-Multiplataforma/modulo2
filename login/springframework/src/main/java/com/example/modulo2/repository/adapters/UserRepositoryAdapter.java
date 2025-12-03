package com.example.modulo2.repository.adapters;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.modulo2.entities.User;
import com.example.modulo2.repository.orm.UserOrm;

public class UserRepositoryAdapter {

    public static UserOrm cast(User user, PasswordEncoder passwordEncoder) {
        return new UserOrm(
            user.username(),
            passwordEncoder.encode(user.senha()),
            user.email()
        );
    }

    public static User cast(UserOrm userOrm) {
        return new User(
            userOrm.getUsername(),
            userOrm.getSenha(),
            userOrm.getEmail()
        );
    }
}
