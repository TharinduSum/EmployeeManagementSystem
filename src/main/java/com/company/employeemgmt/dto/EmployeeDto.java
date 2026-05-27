package com.company.employeemgmt.dto;

public record EmployeeDto(
    Long id,
    String firstName,
    String lastName,
    String email,
    String department,
    String status
) {}
