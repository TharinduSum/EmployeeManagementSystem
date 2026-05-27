package com.company.employeemgmt.controller;

import com.company.employeemgmt.dto.LeaveRequestDto;
import com.company.employeemgmt.model.LeaveRequest;
import com.company.employeemgmt.service.MockDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/leaves")
@RequiredArgsConstructor
public class LeaveController {

    private final MockDataService mockDataService;

    @GetMapping
    public ResponseEntity<List<LeaveRequestDto>> getAllLeaves() {
        List<LeaveRequestDto> dtos = mockDataService.getAllLeaveRequests().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    private LeaveRequestDto mapToDto(LeaveRequest leaveRequest) {
        return new LeaveRequestDto(
                leaveRequest.getId(),
                leaveRequest.getEmployeeId(),
                leaveRequest.getType().name(),
                leaveRequest.getStartDate(),
                leaveRequest.getEndDate(),
                leaveRequest.getStatus().name()
        );
    }
}
