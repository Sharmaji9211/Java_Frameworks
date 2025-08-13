package com.shiva.patients.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.patients.model.Patients;
import com.shiva.patients.repository.Patientsrepository;

@Service
public class PatientsServiceImpl implements PatientsService{

	@Autowired
	private Patientsrepository patientsrepository;

	public void addPatients( Patients patients) {
	patientsrepository.save(patients);
	}

	public Patients getPatientById(int pid) {
		return patientsrepository.findById(pid).orElse(null);
		
	}
	public void deleteById(int pid) {
	patientsrepository.deleteById(pid);
	}
	
	
}
