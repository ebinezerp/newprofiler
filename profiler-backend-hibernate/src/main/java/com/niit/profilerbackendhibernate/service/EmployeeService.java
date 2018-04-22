package com.niit.profilerbackendhibernate.service;

import java.util.List;

import com.niit.profilerbackendhibernate.model.Employee;

public interface EmployeeService {

	public boolean insert(Employee employee);
	public boolean update(Employee employee);
	public boolean delete(Integer employee_Id);
	public Employee getEmployee(Integer employee_Id);
	public List<Employee> getAllEmployees();
	public List<Employee> getUnApprovedEmployees();
	public List<Employee> getApprovedEmployees();
	public List<Employee> getRejectedEmployees();
	public boolean updateStatus(String status,Integer employee_Id);
}
