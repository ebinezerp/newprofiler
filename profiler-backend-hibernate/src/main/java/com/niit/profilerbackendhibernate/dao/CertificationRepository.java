package com.niit.profilerbackendhibernate.dao;

import java.util.List;

import com.niit.profilerbackendhibernate.model.Certification;

public interface CertificationRepository {
	
	public boolean save(Certification certification);
	
	public boolean update(Certification certification);
	
	public boolean delete(Certification certification);
	
	public Certification find(String certificateId);
	
	public List<Certification> findByEmployee(Integer employee_Id);
	

}
