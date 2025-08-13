package com.shiva.patients.service;

import com.shiva.patients.model.Patients;

public interface PatientsService {

	void addPatients(Patients patients);

	Patients getPatientById(int pid);

	void deleteById(int pid);

}
