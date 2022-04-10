package com.example.mapset_10_04_22lesson_2_7.service.impl;


import com.example.mapset_10_04_22lesson_2_7.exception.EmployeeExistsException;
import com.example.mapset_10_04_22lesson_2_7.exception.EmployeeNotFoundException;
import com.example.mapset_10_04_22lesson_2_7.service.Employee;
import com.example.mapset_10_04_22lesson_2_7.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeBook;



    public EmployeeServiceImpl() {
        employeeBook = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lestName) {
        String key = getKey(firstName, lestName);

        if (employeeBook.containsKey(key)) {
            throw new EmployeeExistsException();
        }
        Employee newEmployee = new Employee(firstName, lestName);
        employeeBook.put(key, newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName){
        String key = getKey(firstName, lastName);
        if (employeeBook.remove(key) == null){
            throw new EmployeeNotFoundException();
        }
        Employee newEmployee = new Employee(firstName, lastName);
        return newEmployee;
    }

    @Override
    public  Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        Employee employee = employeeBook.get(key);

        if (employee == null) {
            throw new EmployeeNotFoundException();
        }

        return employee;
    }


    @Override
    public Collection<Employee> getAll(){
        return  Collections.unmodifiableCollection(employeeBook.values());
    }

    private String getKey(String firstName, String lestName){
        return firstName + " " + lestName;
    }

}
