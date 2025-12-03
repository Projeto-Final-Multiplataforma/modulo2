package com.example.modulo2.controller.adapters;

import com.example.modulo2.controller.dto.request.LoginUserRequest;
import com.example.modulo2.controller.dto.request.RegisterUserRequest;
import com.example.modulo2.controller.dto.response.RegisterUserResponse;
import com.example.modulo2.entities.User;

public class LoginControllerAdapter {
    
    public static User cast(RegisterUserRequest request) {
        return new User(
            request.username(),
            request.senha(),
            request.email()
        );
    }

    public static RegisterUserResponse cast(User user) {
        return new RegisterUserResponse(
            user.username(),
            user.email()
        );
    }

    public static User cast(LoginUserRequest request) {
        return new User(
            request.username(),
            request.senha(),
            null
        );
    }
}
