package com.shiva.patients.service;

import com.shiva.patients.model.Patient;


public interface PatientsService {

	Patient getPatientById(Long id);

	void deleteById(Long id);

	Patient addPatient(Patient patients);

}
