package com.company.employeemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payroll {
    private Long id;
    private Long employeeId;
    private BigDecimal salary;
    private String month;
}
