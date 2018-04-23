package com.niit.profilerbackendhibernate.model;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Certification {
	
	@Id
	private String certificationId;
	private String ceritficationName;
	private String certifiedBy;
	private String certificationLicense;
	private String issuedDate;
	private String dueDate;
	
	@ManyToOne
	private Employee employee;

	public String getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(String certificationId) {
		this.certificationId = certificationId;
	}

	public String getCeritficationName() {
		return ceritficationName;
	}

	public void setCeritficationName(String ceritficationName) {
		this.ceritficationName = ceritficationName;
	}

	public String getCertifiedBy() {
		return certifiedBy;
	}

	public void setCertifiedBy(String certifiedBy) {
		this.certifiedBy = certifiedBy;
	}

	public String getCertificationLicense() {
		return certificationLicense;
	}

	public void setCertificationLicense(String certificationLicense) {
		this.certificationLicense = certificationLicense;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Certification [certificationId=" + certificationId + ", ceritficationName=" + ceritficationName
				+ ", certifiedBy=" + certifiedBy + ", certificationLicense=" + certificationLicense + ", issuedDate="
				+ issuedDate + ", dueDate=" + dueDate + ", employee=" + employee + "]";
	}
	
	
	
	
	

}
