package com.company.employeemgmt.service;

import com.company.employeemgmt.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MockDataService {

    private final List<Department> departments = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Payroll> payrolls = new ArrayList<>();
    private final List<LeaveRequest> leaveRequests = new ArrayList<>();

    public MockDataService() {
        initMockData();
    }

    private void initMockData() {
        // Initialize Departments
        departments.add(new Department(1L, "Engineering"));
        departments.add(new Department(2L, "Human Resources"));
        departments.add(new Department(3L, "Finance"));
        departments.add(new Department(4L, "Marketing"));

        // Initialize Employees
        employees.add(new Employee(101L, "Tharindu", "Sumanarathna", "tharindu@accimt.com", "Engineering",
                EmployeeStatus.ACTIVE));
        employees.add(
                new Employee(102L, "Ravindu", "Perera", "ravindu@accimt.com", "Engineering", EmployeeStatus.ACTIVE));
        employees.add(new Employee(103L, "Ayana", "Sagara", "ayana@accimt.com", "Finance", EmployeeStatus.ACTIVE));
        employees.add(new Employee(104L, "Sachini", "Hansani", "sachini@accimt.com", "Human Resources",
                EmployeeStatus.ACTIVE));
        employees
                .add(new Employee(105L, "Dulith", "Gimhan", "dulith@accimt.com", "Marketing", EmployeeStatus.INACTIVE));

        // Initialize Payrolls
        payrolls.add(new Payroll(1L, 101L, new BigDecimal("7500.00"), "2026-05"));
        payrolls.add(new Payroll(2L, 102L, new BigDecimal("8200.00"), "2026-05"));
        payrolls.add(new Payroll(3L, 103L, new BigDecimal("6800.00"), "2026-05"));
        payrolls.add(new Payroll(4L, 104L, new BigDecimal("6200.00"), "2026-05"));

        // Initialize LeaveRequests
        leaveRequests.add(new LeaveRequest(1L, 101L, LeaveType.VACATION, LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 10), LeaveStatus.APPROVED));
        leaveRequests.add(new LeaveRequest(2L, 102L, LeaveType.SICK, LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 12), LeaveStatus.APPROVED));
        leaveRequests.add(new LeaveRequest(3L, 103L, LeaveType.CASUAL, LocalDate.of(2026, 5, 28),
                LocalDate.of(2026, 5, 29), LeaveStatus.PENDING));
    }

    public List<Department> getAllDepartments() {
        return Collections.unmodifiableList(departments);
    }

    public List<Employee> getAllEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public List<Payroll> getAllPayrolls() {
        return Collections.unmodifiableList(payrolls);
    }

    public List<LeaveRequest> getAllLeaveRequests() {
        return Collections.unmodifiableList(leaveRequests);
    }
}
