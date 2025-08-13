package com.shiva.doctor.service;

import com.shiva.doctor.model.Doctor;

public interface DoctorService {

	void addDoctor(Doctor doctor);

	Doctor getDoctorById(int did);

	void deleteById(int did);

}
