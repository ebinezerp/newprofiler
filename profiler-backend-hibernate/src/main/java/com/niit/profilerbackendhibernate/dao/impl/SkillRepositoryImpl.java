package com.niit.profilerbackendhibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.profilerbackendhibernate.dao.SkillRepository;
import com.niit.profilerbackendhibernate.model.Skill;

@Repository
@Transactional
public class SkillRepositoryImpl implements SkillRepository {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean save(Skill skill) {
		
		sessionFactory.getCurrentSession().save(skill);
		
		return true;
	}

	public boolean update(Skill skill) {
		
		sessionFactory.getCurrentSession().update(skill);
		
		return false;
	}

	public boolean delete(Skill skill) {
		
		sessionFactory.getCurrentSession().delete(skill);
		
		return false;
	}

	public List<Skill> findSkills(Integer employee_Id) {
		
		return sessionFactory.getCurrentSession().createQuery("From Skill where employee_employee_Id=:empId",Skill.class)
		.setParameter("empId", employee_Id)
		.getResultList();
	}

}
