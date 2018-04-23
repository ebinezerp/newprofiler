package com.niit.profilerbackendhibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.profilerbackendhibernate.dao.CertificationRepository;
import com.niit.profilerbackendhibernate.model.Certification;
import com.niit.profilerbackendhibernate.model.Employee;

@Repository("certificationRepository")
@Transactional
public class CertificationRepositoryImpl implements CertificationRepository {

	@Autowired
	SessionFactory sessionFactory;

	public boolean save(Certification certification) {

		sessionFactory.getCurrentSession().save(certification);

		return true;
	}

	public boolean update(Certification certification) {
		
		sessionFactory.getCurrentSession().update(certification);

		return true;
	}

	public boolean delete(Certification certification) {
		
		sessionFactory.getCurrentSession().delete(certification);

		return true;
	}

	public Certification find(String certificateId) {
		
		return sessionFactory.getCurrentSession().createQuery("From certification where certificationId=:id",Certification.class)
				.setParameter("id", certificateId)
				.getSingleResult();
	}

	public List<Certification> findByEmployee(Integer employee_Id) {

		
		return sessionFactory.getCurrentSession().createQuery("From certification where employee_employee_Id=:empId",Certification.class)
				.setParameter("empId", employee_Id)
				.getResultList();
		
	}

}
