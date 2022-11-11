package com.deqode.backend2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.deqode.backend2.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

	List<Employee> findByName(String name);
    List<Employee> findByCompany(String company);
    List<Employee> findById(int id);
    
}
