package com.niit.profilerbackendhibernate.service;

import java.util.List;

import com.niit.profilerbackendhibernate.model.Certification;

public interface CertificationService {
	
	public boolean insertCerification(Certification certification);
	public boolean updateCertification(Certification certification);
	public boolean deleteCertification(Certification certification);
	public Certification getCertification(String certificationId);
	public List<Certification> getCertificationsByEmployee(Integer employee_Id);

}
