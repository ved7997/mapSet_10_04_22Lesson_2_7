package com.example.mapset_10_04_22lesson_2_7.controller;


import com.example.mapset_10_04_22lesson_2_7.service.Employee;
import com.example.mapset_10_04_22lesson_2_7.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName){
        Employee result;
        result = employeeService.add(firstName, lastName);
        return generateMesage(result, "успешно создан");
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.remove(firstName, lastName);
        return generateMesage(result, "удалён");
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }
    @GetMapping("/all")
    public Collection<Employee> all() {
        return employeeService.getAll();
    }

    private String generateMesage(Employee employee, String status) {
        return  String.format("Сотрудник %s %s %s.",
                employee.getLastName(),
                employee.getFirstName(),
                status
        );
    }

}
