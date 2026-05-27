package com.company.employeemgmt.controller;

import com.company.employeemgmt.dto.EmployeeDto;
import com.company.employeemgmt.exception.ResourceNotFoundException;
import com.company.employeemgmt.model.Employee;
import com.company.employeemgmt.service.MockDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final MockDataService mockDataService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> dtos = mockDataService.getAllEmployees().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        Employee employee = mockDataService.getAllEmployees().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + id + " not found"));
        return ResponseEntity.ok(mapToDto(employee));
    }

    private EmployeeDto mapToDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getStatus().name()
        );
    }
}
