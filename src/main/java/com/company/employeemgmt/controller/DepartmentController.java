package com.company.employeemgmt.controller;

import com.company.employeemgmt.dto.DepartmentDto;
import com.company.employeemgmt.model.Department;
import com.company.employeemgmt.service.MockDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final MockDataService mockDataService;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> dtos = mockDataService.getAllDepartments().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    private DepartmentDto mapToDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getName()
        );
    }
}
