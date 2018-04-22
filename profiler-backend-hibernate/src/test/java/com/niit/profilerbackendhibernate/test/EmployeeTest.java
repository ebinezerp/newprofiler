package com.niit.profilerbackendhibernate.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.profilerbackendhibernate.config.ApplicationConfig;
import com.niit.profilerbackendhibernate.model.Employee;
import com.niit.profilerbackendhibernate.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ApplicationConfig.class)
public class EmployeeTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@Autowired
	private Employee employee;
	
	@Before
	public void setUp()
	{
		employee.setEmployee_Id(32054);
		employee.setEmail("ebinezer.p87@gmail.com");
		employee.setUsername("ebinezer");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871234");
		
		employeeService.insert(employee);
		
		
	}
	
	@After
	public void tearDown()
	{
		if(employeeService.getEmployee(employee.getEmployee_Id())!=null)
		{
			 employeeService.delete(employee.getEmployee_Id());
		}
	}
	
	@Test
	public void testEmployeeInsert()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		employee.setEmail("ebinezer@gmail.com");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("Test Employee Insert test case is failed",true,employeeService.insert(employee));
	}
	
	
	@Test(expected=SQLIntegrityConstraintViolationException.class)
	public void testEmployeeInsertEmployeeIdDuplicateFailure()
	{
		Employee employee=new Employee();
		//same empId is provided
		employee.setEmployee_Id(32054);
		employee.setEmail("ebinezerp@gmail.com");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("test Employee Insert EmployeeId Duplicate Failure failed",false,employeeService.insert(employee));
	}
	
	@Test(expected=SQLIntegrityConstraintViolationException.class)
	public void testEmployeeInsertEmailDuplicateFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		// same Email Id is provided
		employee.setEmail("ebinezer.p87@gmail.com");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("test Employee Insert Email Duplicate Failure",false,employeeService.insert(employee));
	}
	
	
	@Test(expected=SQLIntegrityConstraintViolationException.class)
	public void testEmployeeInsertEmailWithWrongPatternFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		// Wrong pattern of email is provided
		employee.setEmail("ebine@2345$zer.p87@gmail.com");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("test Employee Insert Email With Wrong Pattern Failure",false,employeeService.insert(employee));
	}
	
	
	@Test(expected=SQLIntegrityConstraintViolationException.class)
	public void testEmployeeInsertUsernameDuplicateFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		employee.setEmail("ebinezer.p@gmail.com");
		// same username is provided
		employee.setUsername("ebinezer");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("test Employee Insert Username Duplicate Failure",false,employeeService.insert(employee));
	}
	
	
	@Test(expected=SQLIntegrityConstraintViolationException.class)
	public void testEmployeeInsertMobileDuplicateFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		employee.setEmail("ebinezer.p@gmail.com");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871234");
		assertEquals("test Employee Insert Mobile Duplicate Failure",false,employeeService.insert(employee));
	}
	

}
