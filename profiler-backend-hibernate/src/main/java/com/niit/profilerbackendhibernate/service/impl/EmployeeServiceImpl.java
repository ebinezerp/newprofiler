package com.niit.profilerbackendhibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.profilerbackendhibernate.dao.EmployeeRepository;
import com.niit.profilerbackendhibernate.model.Employee;
import com.niit.profilerbackendhibernate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public boolean insert(Employee employee) {
		try {
			employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Integer empId) {
		try {
			employeeRepository.delete(getEmployee(empId));
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public Employee getEmployee(Integer empId) {
		try {
			return employeeRepository.find(empId);
		} catch (Exception e) {

			return null;
		}
	}

	public List<Employee> getAllEmployees() {
		try {
			return employeeRepository.findAll();
		} catch (Exception e) {

			return null;
		}
	}

	public List<Employee> getUnApprovedEmployees() {
		try {
			return employeeRepository.findUnApproved();
		} catch (Exception e) {

			return null;
		}
	}

	public List<Employee> getApprovedEmployees() {
		try {
			return employeeRepository.findApproved();
		} catch (Exception e) {

			return null;
		}
	}

	public List<Employee> getRejectedEmployees() {
		try {
			return employeeRepository.findRejected();
		} catch (Exception e) {

			return null;
		}
	}
	
	
	public boolean updateStatus(String status,Integer empId)
	{
		try {
			return employeeRepository.updateStatus(status, empId);
		} catch (Exception e) {

			return false;
		}
	}

	public boolean update(Employee employee) {
		
		
		try {
			return employeeRepository.update(employee);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public List<Employee> getEmployeesBySkill(String skill) {
		
		try {
			return employeeRepository.findBySkill(skill);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public List<Employee> getEmployeesByCertification(String certificationName) {
		
		try {
			return employeeRepository.findByCertification(certificationName);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}


}
