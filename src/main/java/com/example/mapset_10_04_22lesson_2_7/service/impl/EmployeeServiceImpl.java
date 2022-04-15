package com.example.mapset_10_04_22lesson_2_7.service.impl;


import com.example.mapset_10_04_22lesson_2_7.exception.EmployeeExistsException;
import com.example.mapset_10_04_22lesson_2_7.exception.EmployeeNotFoundException;
import com.example.mapset_10_04_22lesson_2_7.service.Employee;
import com.example.mapset_10_04_22lesson_2_7.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeBook = new HashMap<>();

    @Override
    public Employee add(String firstName, String lestName, int salary, int departmentId) {
        String key = getKey(firstName, lestName);
        Employee addingEmployee = new Employee(firstName, lestName, salary, departmentId);
        if (employeeBook.containsKey(key)) {
            throw new EmployeeExistsException();
        }
        employeeBook.put(key, addingEmployee);
        return  addingEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employeeBook.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employeeBook.remove((key));
    }

    @Override
    public  Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
       if (!employeeBook.containsKey(key)){
           throw  new EmployeeNotFoundException();
        }
       return employeeBook.get(key);
    }

    @Override
    public List<Employee> getAll(){
      return new ArrayList<>(employeeBook.values());
    }

    public String getKey(String firstName, String lestName){
        return firstName + " " + lestName;
    }

}
