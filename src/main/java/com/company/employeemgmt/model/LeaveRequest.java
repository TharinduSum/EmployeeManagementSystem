package com.company.employeemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequest {
    private Long id;
    private Long employeeId;
    private LeaveType type;
    private LocalDate startDate;
    private LocalDate endDate;
    private LeaveStatus status;
}
