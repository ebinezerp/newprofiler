package com.niit.profilerbackendhibernate.service;

import java.util.List;

import com.niit.profilerbackendhibernate.model.Skill;

public interface SkillService {
	
	public boolean insertSkill(Skill skill);
	public boolean delete(Skill skill);
	public boolean update(Skill skill);
	public List<Skill>  getSkillByEmployee(Integer employee_Id);
	

}
