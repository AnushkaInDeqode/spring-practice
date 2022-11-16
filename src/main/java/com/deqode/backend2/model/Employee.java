package com.deqode.backend2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Document(collection="Employees")
public class Employee {
	
	@Id
	private String id;
	private String name;
	private String company;
	private Address address;
}
