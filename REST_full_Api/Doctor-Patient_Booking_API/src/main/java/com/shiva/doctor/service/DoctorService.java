package com.shiva.doctor.service;

import java.util.List;

import com.shiva.doctor.model.Doctor;

public interface DoctorService {

	List<Doctor> getAllDoctors();

	Doctor getDoctorById(Long id);

	Doctor saveDoctor(Doctor doctor);

	
}
