package com.example.collections.controller;

import com.example.collections.Object.Employee;
import com.example.collections.service.ServiceEmployee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final ServiceEmployee service;

    public EmployeeController(ServiceEmployee service) {
        this.service = service;
    }

    @GetMapping("add")
    public Employee add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return service.add(firstName, lastName);
    }

    @GetMapping("remove")
    public Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return service.remove(firstName, lastName);
    }

    @GetMapping("find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping("all")
    public List<Employee> all() {
        return service.getAll();
    }
}



