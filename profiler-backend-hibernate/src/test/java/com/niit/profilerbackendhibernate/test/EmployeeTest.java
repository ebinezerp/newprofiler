package com.niit.profilerbackendhibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
	
	@Autowired
	private static Validator validator;
	
	@Before
	public void setUp()
	{
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        
        
		employee.setEmployee_Id(32054);
		employee.setEmail("ebinezer.p87@gmail.com");
		employee.setUsername("ebinezer");
		employee.setPassword("M@nojTkumar123");
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
		employee.setPassword("M@nojTkumar123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("Test Employee Insert test case is failed",true,employeeService.insert(employee));
		employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test
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
		 employeeService.delete(employee.getEmployee_Id());
	}
	
	@Test()
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
		employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test()
	public void testEmployeeInsertEmailWithWrongPatternFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		//Wrong pattern of email is provided
		employee.setEmail("ebine@$$.p87@gmail.com");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		
		//Set<ConstraintViolation<Employee>> errors=validator.validate(employee);
		
		assertEquals("test Employee Insert Email With Wrong Pattern Failure",false,employeeService.insert(employee));
		employeeService.delete(employee.getEmployee_Id());
	}
	
	@Test()
	public void testEmployeeInsertEmailWithNullValueFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		// null of email is provided
		employee.setEmail(null);
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("test Employee Insert Email With Null Value Failure",false,employeeService.insert(employee));
		employeeService.delete(employee.getEmployee_Id());
		
	}
	
	@Test()
	public void testEmployeeInsertEmailWithEmptyValueFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		// empty of email is provided
		employee.setEmail("");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("test Employee Insert Email With Empty value Failure",false,employeeService.insert(employee));
		 employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test()
	public void testEmployeeInsertPasswordWithWrongPatternFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		// empty of email is provided
		employee.setEmail("");
		employee.setUsername("ebinezerp");
		employee.setPassword("abcdf");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("testEmployeeInsertPasswordWithWrongPatternFailure",false,employeeService.insert(employee));
		 employeeService.delete(employee.getEmployee_Id());
	}
	
	@Test()
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
		 employeeService.delete(employee.getEmployee_Id());
	}
	
	@Test()
	public void testEmployeeInsertUsernameWrongPatternValueFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		employee.setEmail("ebinezer.p@gmail.com");
		// wrong patteren
		employee.setUsername("ebinezer876#$@");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("testEmployeeInsertUsernameWrongPatternValueFailure",false,employeeService.insert(employee));
		 employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test()
	public void testEmployeeInsertUsernameNullValueFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		employee.setEmail("ebinezer.p@gmail.com");
		// wrong patteren
		employee.setUsername(null);
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("testEmployeeInsertUsernameNullValueFailure",false,employeeService.insert(employee));
		 employeeService.delete(employee.getEmployee_Id());
	}
	
	@Test()
	public void testEmployeeInsertUsernameEmptyValueFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		employee.setEmail("ebinezer.p@gmail.com");
		// wrong patteren
		employee.setUsername("");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("testEmployeeInsertUsernameEmptyValueFailure",false,employeeService.insert(employee));
		 employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test()
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
		employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test()
	public void testEmployeeInsertMobileWrongPatternFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		employee.setEmail("ebinezer.p@gmail.com");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871234123");
		assertEquals("testEmployeeInsertMobileWrongPatternFailure",false,employeeService.insert(employee));
		employeeService.delete(employee.getEmployee_Id());
	}
	
	

	@Test()
	public void testEmployeeInsertMobileWrongPatternFailure2()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		employee.setEmail("ebinezer.p@gmail.com");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9889adj34");
		assertEquals("testEmployeeInsertMobileWrongPatternFailure2",false,employeeService.insert(employee));
		employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test()
	public void testEmployeeInsertMobileNullValueFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		employee.setEmail("ebinezer.p@gmail.com");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile(null);
		assertEquals("testEmployeeInsertMobileNullValueFailure",false,employeeService.insert(employee));
		employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test()
	public void testEmployeeInsertMobileEmptyValueFailure()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		employee.setEmail("ebinezer.p@gmail.com");
		employee.setUsername("ebinezerp");
		employee.setPassword("Kumar@123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("");
		assertEquals("testEmployeeInsertMobileEmptyValueFailure",false,employeeService.insert(employee));
		employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test()
	public void testEmployeeInsertPasswordWithWrongPatternFailure1()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		// empty of email is provided
		employee.setEmail("");
		employee.setUsername("ebinezerp");
		employee.setPassword("12233");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("ttestEmployeeInsertPasswordWithWrongPatternFailure2",false,employeeService.insert(employee));
		employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test()
	public void testEmployeeInsertPasswordWithWrongPatternFailure2()
	{
		Employee employee=new Employee();
		employee.setEmployee_Id(32053);
		// empty of email is provided
		employee.setEmail("");
		employee.setUsername("ebinezerp");
		employee.setPassword("abc");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871235");
		assertEquals("ttestEmployeeInsertPasswordWithWrongPatternFailure2",false,employeeService.insert(employee));
		employeeService.delete(employee.getEmployee_Id());
	}
	
	
	@Test
	public void testEmployeeGetEmployee()
	{
		assertEquals("testEmployeeGetEmployee failed",employee,employeeService.getEmployee(employee.getEmployee_Id()));
	}
	
	@Test
	public void testEmployeeGetEmployeeFailure()
	{
		assertNull("testEmployeeGetEmployeeFailure failed",employeeService.getEmployee(100));
	}
	
	
	/*@Test
	public void testGetEmployeeByName()
	{
		assertEquals("testEmployeeGetEmployee failed",employee,employeeService);
	}*/
	

}
