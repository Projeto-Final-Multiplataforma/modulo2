package com.example.modulo2.controller.dto.request;

public record RegisterUserRequest(
    String username,
    String senha,
    String email
    
) {}

