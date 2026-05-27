package com.company.employeemgmt.dto;

public record LoginResponse(
    String token,
    String type,
    long expiresInMs
) {}
