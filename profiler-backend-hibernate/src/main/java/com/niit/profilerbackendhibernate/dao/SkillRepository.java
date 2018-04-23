package com.niit.profilerbackendhibernate.dao;

import java.util.List;

import com.niit.profilerbackendhibernate.model.Skill;

public interface SkillRepository {
	
	public boolean save(Skill skill);
	public boolean update(Skill skill);
	public boolean delete(Skill skill);
	public List<Skill> findSkills(Integer employee_Id);

}
