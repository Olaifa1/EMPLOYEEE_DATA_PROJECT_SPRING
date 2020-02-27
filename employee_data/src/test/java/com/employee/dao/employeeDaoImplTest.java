/**
 * 
 */
package com.employee.dao;

import static org.assertj.core.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.entity.Employee;

/**
 * @author Olaifa
 *
 */

@Sql(scripts= {"classpath:/db/create-table.sql", "classpath:/db/insert-employee.sql"})
@ContextConfiguration("classpath:data-context.xml")
@RunWith(SpringRunner.class)
public class employeeDaoImplTest {

	@Autowired
	Environment env;
	
	@Autowired
	private EmployeeDao employeeDaoImpl;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	
	
	@Test
public void saveEmployeeToDBTest() {
	Employee newEmployee = new Employee();
	newEmployee.setFirstName("Mary");
	newEmployee.setLastName("Black");
	newEmployee.setEmail("mary@mail.com");
	newEmployee.setPhoneNumber("08180956267");
	
	Date employeeDate = Date.valueOf("2007-07-04");
	newEmployee.setDateOfBirth(employeeDate);
	
	assertThat(employeeDaoImpl).isNotNull();
	employeeDaoImpl.saveEmployee(newEmployee);
	
	int id = newEmployee.getEmployeeId();
	
	System.out.println("New Employee Id -->" + id);
	
	Employee existingEmployee = employeeDaoImpl.getById(id);
	assertThat(existingEmployee).isNotNull();
} 
	
	@Test
	public void getEmployeeByEmailTest() {
		assertThat(employeeDaoImpl).isNotNull();
		
		Employee savedEmployee = employeeDaoImpl.getByEmail("olaifawaliu@rocketmail.com");
		
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getEmployeeId()).isEqualTo(7);
		
		System.out.println(savedEmployee);
	}
	
	@Test
	public void getAllEmployeesTest() {
		assertThat(employeeDaoImpl).isNotNull();
		List<Employee> savedEmployee = employeeDaoImpl.findAll();
		
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee).hasSize(5);
		
		savedEmployee.forEach(System.out::println);
		
	}
}
