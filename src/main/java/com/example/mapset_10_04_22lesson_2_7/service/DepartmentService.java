package com.example.mapset_10_04_22lesson_2_7.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee employeeWithMaxSalary(int departmentId);

    Employee employeeWithMinSalary(int departmentId);

    Collection<Employee> findEmployeesByDepartment(int departmentId);

    Map<Integer, List<Employee>> findAllEmployeesByDepartment();

}