package com.example.collections.service;

import com.example.collections.Object.Employee;
import com.example.collections.exception.EmployeeAlreadyAddedException;
import com.example.collections.exception.EmployeeNotFoundException;
import com.example.collections.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceEmployee {
    private final Map<String, Employee> employees = new HashMap<>();
    private static final int MAX_SIZE = 5;

    public Employee add(String firstName, String lastName) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employeeToAdd = new Employee(firstName, lastName);
        if (employees.containsKey(employeeToAdd.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employeeToAdd.getFullName(), employeeToAdd);
        return employeeToAdd;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeToRemove = new Employee(firstName, lastName);
        if (!employees.containsKey(employeeToRemove.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(employeeToRemove.getFullName());

    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(employees.values()));
    }
}
