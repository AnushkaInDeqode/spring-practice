package com.deqode.backend2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Employees")
public class Employee {

	public Employee(String name2, String company2, String address2) {
		this.name=name2;
		this.company=company2;
		this.address=address2;
	}
	
	@Id
	private int id;
	private String name;
	private String company;
	private String address;
}
