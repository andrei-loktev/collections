package com.example.collections.controller;

import com.example.collections.Object.Employee;
import com.example.collections.service.ServiceEmployee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final ServiceEmployee serviceEmployee;

    public EmployeeController(ServiceEmployee service) {
        this.serviceEmployee = service;
    }

    @GetMapping("add")
    public Employee add(@RequestParam("firstName")String firstName , @RequestParam("lastName") String lastName ) {
        return serviceEmployee.add(firstName, lastName);
    }
    @GetMapping("remove")
    public Employee remove(@RequestParam("firstName")String firstName , @RequestParam("lastName") String lastName ) {
        return serviceEmployee.remove(firstName, lastName);
    }
    @GetMapping("find")
    public Employee find(@RequestParam("firstName")String firstName , @RequestParam("lastName") String lastName ) {
        return serviceEmployee.find(firstName, lastName);
    }

    @GetMapping("all")
    public List<Employee> all(){
        return serviceEmployee.getAll();
    }
}



