package com.niit.profilerbackendhibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.profilerbackendhibernate.dao.SkillRepository;
import com.niit.profilerbackendhibernate.model.Skill;
import com.niit.profilerbackendhibernate.service.EmployeeService;
import com.niit.profilerbackendhibernate.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private EmployeeService employeeService;

	public boolean insertSkill(Skill skill) {

		try {
			skillRepository.save(skill);
			return true;
		} catch (Exception e) {

			return false;

		}

	}

	public boolean delete(Skill skill) {
		try {
			skillRepository.delete(skill);
			return true;
		} catch (Exception e) {

			return false;

		}

	}

	public boolean update(Skill skill) {
		try {
			skillRepository.update(skill);
			return true;
		} catch (Exception e) {

			return false;

		}
	}

	public List<Skill> getSkillByEmployee(Integer employee_Id) {

		try {
			if (employeeService.getEmployee(employee_Id) != null) {
					
				return skillRepository.findSkills(employee_Id);
			}else
			{
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			return null;
		}

	}

}
