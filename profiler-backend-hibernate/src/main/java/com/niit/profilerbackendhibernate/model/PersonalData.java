package com.niit.profilerbackendhibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PersonalData {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rowId;
	
	
	@NotNull
	@OneToOne
	private Employee employee;
	
	@NotNull(message="Enter First Name")
	@NotBlank(message="Enter the First Number")
	@Pattern(regexp="[A-Za-z]{3,15}",message="Only Alphabet. Min 3 and Max 15")
	@Column(nullable=false)
	private String firstname;
	
	
	@NotNull(message="Enter Last Name")
	@NotBlank(message="Enter Last Number")
	@Pattern(regexp="[A-Za-z]{3,15}",message="Only Alphabet. Min 3 and Max 15")
	@Column(nullable=false)
	private String lastname;
	
	@NotNull
	@NotBlank
	@Column(nullable=false)
	private String gender;
	
	
	@NotNull
	@DateTimeFormat(pattern="^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$")
	@Pattern(regexp="^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$",message="Enter a valid format. YYYY-MM-DD")
	@Column(nullable=false)
	private Date date_Of_Birth;
	
	
	@NotNull
	@Column(nullable=false)
	private Boolean marital_Status;
	
	
	

	private String city;
	private Long supervisor;

	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate_Of_Birth() {
		return date_Of_Birth;
	}
	public void setDate_Of_Birth(Date date_Of_Birth) {
		this.date_Of_Birth = date_Of_Birth;
	}
	public Boolean getMarital_Status() {
		return marital_Status;
	}
	public void setMarital_Status(Boolean marital_Status) {
		this.marital_Status = marital_Status;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Long supervisor) {
		this.supervisor = supervisor;
	}
	public Integer getRowId() {
		return rowId;
	}
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((date_Of_Birth == null) ? 0 : date_Of_Birth.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((marital_Status == null) ? 0 : marital_Status.hashCode());
		result = prime * result + ((rowId == null) ? 0 : rowId.hashCode());
		result = prime * result + ((supervisor == null) ? 0 : supervisor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalData other = (PersonalData) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (date_Of_Birth == null) {
			if (other.date_Of_Birth != null)
				return false;
		} else if (!date_Of_Birth.equals(other.date_Of_Birth))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (marital_Status == null) {
			if (other.marital_Status != null)
				return false;
		} else if (!marital_Status.equals(other.marital_Status))
			return false;
		if (rowId == null) {
			if (other.rowId != null)
				return false;
		} else if (!rowId.equals(other.rowId))
			return false;
		if (supervisor == null) {
			if (other.supervisor != null)
				return false;
		} else if (!supervisor.equals(other.supervisor))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "PersonalData [rowId=" + rowId + ", employee=" + employee + ", firstname=" + firstname + ", lastname="
				+ lastname + ", gender=" + gender + ", date_Of_Birth=" + date_Of_Birth + ", marital_Status="
				+ marital_Status + ", city=" + city + ", supervisor=" + supervisor + "]";
	}
	
	
	
	
	

}
