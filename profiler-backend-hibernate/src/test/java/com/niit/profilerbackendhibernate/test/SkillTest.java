package com.niit.profilerbackendhibernate.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.profilerbackendhibernate.config.ApplicationConfig;
import com.niit.profilerbackendhibernate.model.Employee;
import com.niit.profilerbackendhibernate.model.Skill;
import com.niit.profilerbackendhibernate.service.EmployeeService;
import com.niit.profilerbackendhibernate.service.SkillService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ApplicationConfig.class)
public class SkillTest {
	
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Skill skill;
	
	private List<Skill> skills;
	
	@Autowired
	private Employee employee;
	
	@Before
	public void setUp()
	{
	
		employee.setEmployee_Id(32057);
		employee.setEmail("ebinezer.p87@gmail.com");
		employee.setUsername("ebinezer");
		employee.setPassword("M@nojTkumar123");
		employee.setRole("Employee");
		employee.setDesignation("Tech Mentor");
		employee.setMobile("9845871234");
		
		employeeService.insert(employee);
		
		Skill skill1=new Skill();
		skill1.setEmployee(employeeService.getEmployee(32057));
		skill1.setSkillName("Java");
		skill1.setVersion("1.8");
		skill1.setMonthsOfTraining(24);
		skill1.setMonthsOfPractice(38);
		
		
		Skill skill2=new Skill();
		skill2.setEmployee(employeeService.getEmployee(32057));
		skill2.setSkillName("J2EE");
		skill2.setVersion("1.8");
		skill2.setMonthsOfTraining(24);
		skill2.setMonthsOfPractice(38);
		
		Skill skill3=new Skill();
		skill3.setEmployee(employeeService.getEmployee(32057));
		skill3.setSkillName("J2EE");
		skill3.setVersion("1.8");
		skill3.setMonthsOfTraining(24);
		skill3.setMonthsOfPractice(38);
		
		skills=new ArrayList<Skill>();
		
		skills.add(skill1);
		skills.add(skill2);
		skills.add(skill3);
		
		
		employee.setSkills(skills);
		
		skillService.insertSkill(skill1);
		skillService.insertSkill(skill2);
		skillService.insertSkill(skill3);
		
		
		employeeService.update(employee);
		
		
	}
	
	@After
	public void tearDown()
	{
		
		
		
		if(skillService.getSkillByEmployee(employee.getEmployee_Id())!=null)
		{
		        for(Skill skill:skillService.getSkillByEmployee(employee.getEmployee_Id()))
		        {
		        	skillService.delete(skill);
		        }
		}
		
		if(employeeService.getEmployee(employee.getEmployee_Id())!=null)
		{
			employeeService.delete(employee.getEmployee_Id());
		}
		
	}
	
	
	@Test
	public void testInsertSkills()
	{
		Skill skill1=new Skill();
		skill1.setEmployee(employeeService.getEmployee(32057));
		skill1.setSkillName("Hibernate");
		skill1.setVersion("5");
		skill1.setMonthsOfTraining(8);
		skill1.setMonthsOfPractice(12);
		
		
		Skill skill2=new Skill();
		skill2.setEmployee(employeeService.getEmployee(32057));
		skill2.setSkillName("HTML");
		skill2.setVersion("5");
		skill2.setMonthsOfTraining(24);
		skill2.setMonthsOfPractice(38);
		
		
		assertEquals("Insert Skills Failed...",true,skillService.insertSkill(skill1));
		assertEquals("Insert Skills Failed...",true,skillService.insertSkill(skill2));
		
		skills.add(skill1);
		skills.add(skill2);
		
		employee.setSkills(skills);
		
		assertEquals("Update Employee In insert Skill is failed", true,employeeService.update(employee));
		
	}

}
