package com.deqode.backend2;

import com.deqode.backend2.model.Address;
import com.deqode.backend2.model.Employee;
import com.deqode.backend2.repository.EmployeeRepository;
import com.deqode.backend2.service.EmployeeService;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
class SpringpracticeApplicationTests {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;

	private static Employee emp;

	@BeforeAll
	static void setUp() {
		emp = new Employee("101","Anushka","Deqode",new Address("abc","Prayagraj","UP"));
	}

	@Test
	void getAllEmployees() {
		when(employeeRepository.findAll()).thenReturn(List.of(emp));
		List<Employee> studentList = employeeService.getEmployees();
		Assert.notEmpty(studentList, "Employee list should not be empty");
	}

	@Test
	void saveEmployee() {
		when(employeeRepository.save(any())).thenReturn(emp);
		Assert.notNull(employeeService.addEmployee(emp), "Employee list should not be empty");
	}

	@Test
	void deleteEmployee() {
		doNothing().when(employeeRepository).deleteById(anyString());
		employeeService.deleteEmployee("101");
		verify(employeeRepository, times(1)).deleteById(anyString());
	}
}
