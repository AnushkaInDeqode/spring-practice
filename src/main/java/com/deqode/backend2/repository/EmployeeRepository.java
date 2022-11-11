package com.deqode.backend2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.deqode.backend2.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
