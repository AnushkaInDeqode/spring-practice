package com.deqode.backend2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deqode.backend2.model.Employee;
import com.deqode.backend2.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	public Employee addEmployee(Employee emp) {
		
	    return empRepository.save(emp);      
	}

	public Employee getEmployeeById(String id) {
	    	
	    return empRepository.findById(id).get();
	}

	public List<Employee> getEmployees() {

	    return empRepository.findAll();
	}	
	    
	public void deleteEmployee(String id) {
		
		empRepository.deleteById(id);
	}
}
