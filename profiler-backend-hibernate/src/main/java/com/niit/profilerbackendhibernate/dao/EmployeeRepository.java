package com.niit.profilerbackendhibernate.dao;

import java.util.List;

import com.niit.profilerbackendhibernate.model.Employee;

public interface EmployeeRepository {
	
	public boolean  save(Employee employee);
	public boolean  update(Employee employee);
	public boolean  updateStatus(String status,Integer empId);
	public Employee find(Integer id);
	public Employee findByEmployeeEmail(String email);
	public boolean  delete(Employee e);
	public List<Employee>  findAll();
	public List<Employee>  findApproved();
	public List<Employee>  findUnApproved();
	public List<Employee>  findRejected();
	public List<Employee>  findBySkill(String skill);
	public List<Employee>  findByCertification(String certificationName);
	
	
}
