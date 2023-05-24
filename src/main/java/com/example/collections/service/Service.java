package com.example.collections.service;

import com.example.collections.controller.Employee;
import com.example.collections.exception.EmployeeAlreadyAddedException;
import com.example.collections.exception.EmployeeNotFoundException;
import com.example.collections.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    private final List<Employee> employees = new ArrayList<>();
    private static final int MAX_SIZE = 5;

    public Employee add(Employee employee) {
        if(employees.size()>=MAX_SIZE){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee remove(Employee employee) {
        if(employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (firstName.equalsIgnoreCase(employee.getFirstName())
                    && lastName.equalsIgnoreCase(employee.getLastName())) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
}
