package com.deqode.backend2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deqode.backend2.model.Employee;
import com.deqode.backend2.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee emp) {
        return empService.addEmployee(emp);
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return empService.getEmployeeById(id);
    }

    @GetMapping("/getEmployee")
    public List<Employee> getAllStudents() {
        return empService.getEmployees();
    }
    
    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable("id") String id) {
    	empService.deleteEmployee(id);
    }
}

