package com.shiva.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shiva.doctor.model.Doctor;
import com.shiva.doctor.service.DoctorService;


@RestController
public class DoctorController
{
	 
	@Autowired
	private DoctorService doctorService;
	 
	@PostMapping("doctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		doctorService.addDoctor(doctor);
		return doctor;
	}
	@GetMapping("/did")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int did){
		Doctor doctor = doctorService.getDoctorById(did);
		if(doctor==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(doctor);
		
	}
	@DeleteMapping("/did")
	public ResponseEntity<Doctor> doctorDeleteById(@PathVariable int did){
		
		Doctor doctor= doctorService.getDoctorById(did);
		if(doctor==null) {
			return ResponseEntity.notFound().build();
		}
		doctorService.deleteById(did);
		return ResponseEntity.ok(doctor);
	}
}
