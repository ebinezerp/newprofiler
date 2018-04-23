package com.niit.profilerbackendhibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Skill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long skillId;
	private String skillName;
	private String version;
	private int monthsOfPractice;
	private int monthsOfTraining;
	
	
	@ManyToOne
	private Employee employee;
	
	
	public long getSkillId() {
		return skillId;
	}
	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getMonthsOfPractice() {
		return monthsOfPractice;
	}
	public void setMonthsOfPractice(int monthsOfPractice) {
		this.monthsOfPractice = monthsOfPractice;
	}
	public int getMonthsOfTraining() {
		return monthsOfTraining;
	}
	public void setMonthsOfTraining(int monthsOfTraining) {
		this.monthsOfTraining = monthsOfTraining;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", version=" + version + ", monthsOfPractice="
				+ monthsOfPractice + ", monthsOfTraining=" + monthsOfTraining + ", employee=" + employee + "]";
	}


	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (monthsOfPractice != other.monthsOfPractice)
			return false;
		if (monthsOfTraining != other.monthsOfTraining)
			return false;
		if (skillId != other.skillId)
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	

	
}
