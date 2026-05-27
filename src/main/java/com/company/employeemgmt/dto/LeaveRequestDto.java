package com.company.employeemgmt.dto;

import java.time.LocalDate;

public record LeaveRequestDto(
    Long id,
    Long employeeId,
    String type,
    LocalDate startDate,
    LocalDate endDate,
    String status
) {}
