package com.niit.profilerbackendhibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.profilerbackendhibernate.dao.CertificationRepository;
import com.niit.profilerbackendhibernate.model.Certification;
import com.niit.profilerbackendhibernate.service.CertificationService;
import com.niit.profilerbackendhibernate.service.EmployeeService;

@Service
public class CertificationServiceImpl implements CertificationService {

	@Autowired
	private CertificationRepository certificationRepository;

	@Autowired
	private EmployeeService employeeService;

	public boolean insertCerification(Certification certification) {

		try {
			if (employeeService.getEmployee(certification.getEmployee().getEmployee_Id()) != null) {
				return certificationRepository.save(certification);
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public boolean updateCertification(Certification certification) {
		try {
			if (employeeService.getEmployee(certification.getEmployee().getEmployee_Id()) != null) {
				return certificationRepository.update(certification);
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteCertification(Certification certification) {


		try {
			if (employeeService.getEmployee(certification.getEmployee().getEmployee_Id()) != null) {
				return certificationRepository.update(certification);
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}

	public Certification getCertification(String certificationId) {

		try {
			  return certificationRepository.find(certificationId);
		} catch (Exception e) {
			// TODO: handle exception
			
			return null;
		}
		
	}

	public List<Certification> getCertificationsByEmployee(Integer employee_Id) {


		try {
			if (employeeService.getEmployee(employee_Id) != null) {
				return certificationRepository.findByEmployee(employee_Id);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		
	}

}
