package com.company.employeemgmt.controller;

import com.company.employeemgmt.dto.PayrollDto;
import com.company.employeemgmt.model.Payroll;
import com.company.employeemgmt.service.MockDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payrolls")
@RequiredArgsConstructor
public class PayrollController {

    private final MockDataService mockDataService;

    @GetMapping
    public ResponseEntity<List<PayrollDto>> getAllPayrolls() {
        List<PayrollDto> dtos = mockDataService.getAllPayrolls().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    private PayrollDto mapToDto(Payroll payroll) {
        return new PayrollDto(
                payroll.getId(),
                payroll.getEmployeeId(),
                payroll.getSalary(),
                payroll.getMonth()
        );
    }
}
