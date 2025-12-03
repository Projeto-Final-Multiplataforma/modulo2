package com.example.modulo2.controller.advices;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.modulo2.controller.dto.response.ErrorResponse;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleAuthenticationException(AuthenticationException e) {
        return new ErrorResponse(
            "Erro ao logar",
            e.getMessage(),
            401
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGenericException(Exception e) {

        return new ErrorResponse(
            "Erro interno do servidor",
            e.getMessage(),
            500
        );
    }
}

