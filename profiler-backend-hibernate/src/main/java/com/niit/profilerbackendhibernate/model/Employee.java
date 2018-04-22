package com.niit.profilerbackendhibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity

public class Employee {

	@Id
	@NotNull(message = "Enter employee Id")
/*	@NotBlank(message = "Enter employee Id")*/
	private Integer employee_Id;

	@NotBlank(message = "Enter the email")
	@NotNull(message = "Enter valid email Id")
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "Enter a valid email Id")
	@Column(unique=true,nullable=false)
	private String email;

	@NotBlank(message = "Enter mobile Number")
	@NotNull(message = "Enter valid mobile Number")
	@Pattern(regexp = "^([+][9][1]|[9][1]|[0]){0,1}([7-9]{1})([0-9]{9})$", message = "Enter valid mobile number")
	@Column(unique=true,nullable=false)
	private String mobile;

	@NotBlank(message = "Enter Role Filed")
	@NotNull(message = "Enter valid Role")
	@Column(nullable=false)
	private String role;

	@NotBlank(message = "Enter Designation")
	@NotNull(message = "Enter valid Designation")
	@Pattern(regexp = "[A-Za-z\\s]{4,40}", message = "Enter a valid Designation. Only Alphabet and white space. Min 4 and Max 40 characters")
	@Column(nullable=false)
	private String designation;

	@NotBlank(message = "Enter Username")
	@NotNull(message = "Enter valid Username")
	@Pattern(regexp = "[A-Za-z0-9]{5,15}", message = "Enter a valid Designation. Only AlphaNumeric. Min 5 and Max 15 characters")
	@Column(unique=true,nullable=false)
	private String username;

	@NotBlank(message = "Enter Username")
	@NotNull(message = "Enter valid Username")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$", message = "Min 8 and Max 20 characters. Atleast One Samll, One Capital, One Numeric and One Special Characters")
	@Column(nullable=false)
	private String password;
	
	
	
/*	@NotNull(message = "Enter First Name")
	@NotBlank(message = "Enter the First Number")
	@Pattern(regexp = "[A-Za-z]{3,15}", message = "Only Alphabet. Min 3 and Max 15")*/
	private String firstname;

	/*@NotNull(message = "Enter Last Name")
	@NotBlank(message = "Enter Last Number")
	@Pattern(regexp = "[A-Za-z]{3,15}", message = "Only Alphabet. Min 3 and Max 15")*/
	private String lastname;

/*	@NotNull
	@NotBlank*/
	private String gender;

	/*@NotNull
	@DateTimeFormat(pattern = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$",style="YYYY-MM-DD")*/
	private Date date_Of_Birth;

	/*@NotNull*/
	private Boolean marital_Status;
	
	/*@NotNull
	@Pattern(regexp="[a-zA-Z0-9\\s]{3,20}",message="Min 3 and Max 5 characters")*/
	private String city;
	
/*	@Column(nullable=false)
	@NotNull*/
	private Long supervisor;
	

	public Employee() {

	}

	public Employee(int employee_Id, String email, String mobile, String role, String designation, String username,
			String password) {
		super();
		this.employee_Id = employee_Id;
		this.email = email;
		this.mobile = mobile;
		this.role = role;
		this.designation = designation;
		this.username = username;
		this.password = password;
	}

	public Integer getEmployee_Id() {
		return employee_Id;
	}

	
	public void setEmployee_Id(Integer employee_Id) {
		this.employee_Id = employee_Id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", email=" + email + ", mobile=" + mobile + ", role=" + role
				+ ", designation=" + designation + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", gender=" + gender + ", date_Of_Birth=" + date_Of_Birth
				+ ", marital_Status=" + marital_Status + ", city=" + city + ", supervisor=" + supervisor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((date_Of_Birth == null) ? 0 : date_Of_Birth.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employee_Id == null) ? 0 : employee_Id.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((marital_Status == null) ? 0 : marital_Status.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((supervisor == null) ? 0 : supervisor.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Employee other = (Employee) obj;
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
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employee_Id == null) {
			if (other.employee_Id != null)
				return false;
		} else if (!employee_Id.equals(other.employee_Id))
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
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (supervisor == null) {
			if (other.supervisor != null)
				return false;
		} else if (!supervisor.equals(other.supervisor))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	

	
	
	
}
