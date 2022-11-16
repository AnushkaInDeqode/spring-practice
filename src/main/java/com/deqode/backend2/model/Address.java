package com.deqode.backend2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

	String street;
	String city;
	String state;
}
