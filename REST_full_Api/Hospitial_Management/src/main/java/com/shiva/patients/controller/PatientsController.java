package com.shiva.patients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shiva.patients.model.Patients;
import com.shiva.patients.service.PatientsService;

@RestController
public class PatientsController {

	@Autowired
	private PatientsService patientsService;

	@PostMapping("patients")
	public Patients addPatient(@RequestBody Patients patients) {
		patientsService.addPatients(patients);
		return patients;
	}

	@GetMapping("/pid")
	public ResponseEntity<Patients> getPatientById(@PathVariable int pid) {
		Patients patient = patientsService.getPatientById(pid);
		if (patient == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(patient);

	}

	@DeleteMapping("/pid")
	public ResponseEntity<Patients> deleteById(@PathVariable int pid) {

		Patients patient = patientsService.getPatientById(pid);
		if (patient == null) {
			return ResponseEntity.notFound().build();
		}
		patientsService.deleteById(pid);
		return ResponseEntity.ok(patient);
	}
}
