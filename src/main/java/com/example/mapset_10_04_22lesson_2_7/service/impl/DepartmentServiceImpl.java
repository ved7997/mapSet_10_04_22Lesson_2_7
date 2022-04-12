package com.example.mapset_10_04_22lesson_2_7.service.impl;

import com.example.mapset_10_04_22lesson_2_7.exception.EmployeeNotFoundException;
import com.example.mapset_10_04_22lesson_2_7.service.DepartmentService;
import com.example.mapset_10_04_22lesson_2_7.service.Employee;
import com.example.mapset_10_04_22lesson_2_7.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Override
    public Employee employeeWithMaxSslarey(int departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));

    }

    @Override
    public Employee employeeWithMinSslarey(int departmentId) {
        return null;
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        return null;
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployees() {
        return null;
    }
}
