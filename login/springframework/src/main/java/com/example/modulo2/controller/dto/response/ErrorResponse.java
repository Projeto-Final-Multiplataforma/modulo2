package com.example.modulo2.controller.dto.response;

public record ErrorResponse(
    String mensagem,
    String erro,
    Integer status
) {}
