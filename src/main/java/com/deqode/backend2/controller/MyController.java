package com.deqode.backend2.controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deqode.backend2.model.Employee;
import com.deqode.backend2.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class MyController {

	@Autowired
	private EmployeeRepository empRepository;
	
	@GetMapping("/getEmp/{name}")
	public ResponseEntity<List> getEmployeebyName(@RequestParam(required = false) String name){

		try{
			
            List empList = new ArrayList<>();
            
            if(name == null || name.isEmpty())
            	empRepository.findAll().forEach(empList::add);
            
            else
            	empRepository.findByName(name).forEach(empList::add);
            
            if(empList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<>(empList, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@GetMapping("/getEmp/{id}")
    public ResponseEntity getEmployeeById(@PathVariable("id") Integer id)
    {
        try
        {
        	Optional<Employee> empId = empRepository.findById(id);

            return new ResponseEntity<>(empId.get(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/getEmp/{company}")
    public ResponseEntity getEmployeeByCompany(@RequestParam(required = false) String company)
    {
        try
        {
        	List<Employee> empId = empRepository.findByCompany(company);

            return new ResponseEntity<>(empId.get(0), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PostMapping("/addEmp")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp){

		try
        {
            Employee createdEmp = empRepository.save(new Employee(emp.getName(), emp.getCompany(), emp.getAddress()));
            return new ResponseEntity<>(createdEmp, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	   
	}
	
	@PutMapping("/employee/{id}")
    public ResponseEntity updateABook(@PathVariable("id") Integer id, @RequestBody Employee emp)
    {
        Optional empId = empRepository.findById(id);

        if(empId.isPresent())
        {
            Employee updatedEmployee = (Employee) empId.get();
            updatedEmployee.setName(emp.getName());
            updatedEmployee.setCompany(emp.getCompany());
            updatedEmployee.setAddress(emp.getAddress());
            return new ResponseEntity<>(empRepository.save(updatedEmployee), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteABook(@PathVariable("id") Integer id)
    {
        try
        {
            empRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

