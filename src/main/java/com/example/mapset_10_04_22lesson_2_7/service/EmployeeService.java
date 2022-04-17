package com.example.mapset_10_04_22lesson_2_7.service;

import java.util.Collection;

public interface EmployeeService {


    Employee add(String firstName, String lastName, int salary, int departmentId);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getAll();


}

