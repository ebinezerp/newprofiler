package com.niit.profilerbackendhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", email=" + email + ", mobile=" + mobile + ", role=" + role
				+ ", designation=" + designation + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employee_Id == null) ? 0 : employee_Id.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
