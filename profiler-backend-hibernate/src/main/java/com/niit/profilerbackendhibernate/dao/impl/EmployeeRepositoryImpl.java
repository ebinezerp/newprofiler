package com.niit.profilerbackendhibernate.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.profilerbackendhibernate.dao.EmployeeRepository;
import com.niit.profilerbackendhibernate.model.Employee;

@Repository("employeeRepository")
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean save(Employee employee) {

		sessionFactory.getCurrentSession().save(employee);
		return true;

	}

	public boolean update(Employee employee) {

		sessionFactory.getCurrentSession().update(employee);
		return true;

	}

	public Employee find(Integer empId) {

		return sessionFactory.getCurrentSession().createQuery("From Employee where employee_Id=:empId", Employee.class)
				.setParameter("empId", empId).getSingleResult();
	}

	public Employee findByEmployeeEmail(String email) {

		return sessionFactory.getCurrentSession().createQuery("From Employee where email=:email", Employee.class)
				.setParameter("email", email).getSingleResult();
	}

	public boolean delete(Employee employee) {

		sessionFactory.getCurrentSession().delete(employee);

		return true;
	}

	public List<Employee> findAll() {

		return sessionFactory.getCurrentSession().createQuery("From Employee", Employee.class).getResultList();

	}

	public List<Employee> findApproved() {

		return sessionFactory.getCurrentSession().createQuery("From Employee where status='approved'", Employee.class)
				.getResultList();

	}

	public List<Employee> findUnApproved() {

		return sessionFactory.getCurrentSession().createQuery("From Employee where status='pending'", Employee.class)
				.getResultList();

	}

	public List<Employee> findRejected() {
		return sessionFactory.getCurrentSession().createQuery("From Employee where status='rejected'", Employee.class)
				.getResultList();
	}

	public boolean updateStatus(String status,Integer empId) {
		
		sessionFactory.getCurrentSession().createQuery("UPDATE Employee set status=:status where employee_Id=:empid")
		.setParameter("empid", empId)
		.setParameter("status", status)
		.executeUpdate();
		return true;
	}

	public List<Employee> findBySkill(String skill) {
		
		return sessionFactory.getCurrentSession().createQuery("From Employee where employee_Id IN (select employee_employee_Id From Skill where skillName like %:skillName%)",Employee.class)
		.setParameter("skillName", skill)
		.getResultList();
		
	}

	public List<Employee> findByCertification(String certificationName) {
		
		return sessionFactory.getCurrentSession().createQuery("From Employee where employee_Id IN (select employee_employee_Id from Certification where certificationName like %:name%)",Employee.class)
				.setParameter("name", certificationName)
				.getResultList();
	}

}
