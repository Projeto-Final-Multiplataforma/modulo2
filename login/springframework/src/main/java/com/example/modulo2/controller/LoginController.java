package com.example.modulo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modulo2.controller.adapters.LoginControllerAdapter;
import com.example.modulo2.controller.dto.request.LoginUserRequest;
import com.example.modulo2.controller.dto.request.RegisterUserRequest;
import com.example.modulo2.controller.dto.response.LoginUserResponse;
import com.example.modulo2.controller.dto.response.RegisterUserResponse;
import com.example.modulo2.entities.Token;
import com.example.modulo2.repository.UserRepository;
import com.example.modulo2.security.TokenSecurity;

@RestController
@RequestMapping("v1")
public class LoginController {

    private final UserRepository userRepository;
    private final TokenSecurity tokenSecurity;
    public LoginController(UserRepository userRepository, TokenSecurity tokenSecurity) {
        this.userRepository = userRepository;
        this.tokenSecurity = tokenSecurity;
    }

    @PostMapping("/login")
    public LoginUserResponse login(@RequestBody LoginUserRequest request) {
        Token token = tokenSecurity.logar(LoginControllerAdapter.cast(request));
        return new LoginUserResponse(token.value());
    }

    @PostMapping("/registrar")
    public RegisterUserResponse registerUser(@RequestBody RegisterUserRequest request) {
        return LoginControllerAdapter.cast(
            userRepository.criar(LoginControllerAdapter.cast(request))
        );
    }

    @GetMapping("/rota-protegida")
    public String rotaProtegida() {
        return "Hello, world!";
    }
}
