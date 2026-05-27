package com.company.employeemgmt.dto;

import java.math.BigDecimal;

public record PayrollDto(
    Long id,
    Long employeeId,
    BigDecimal salary,
    String month
) {}
