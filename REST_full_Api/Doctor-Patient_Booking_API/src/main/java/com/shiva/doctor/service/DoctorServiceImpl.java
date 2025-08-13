package com.shiva.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiva.doctor.model.Doctor;
import com.shiva.doctor.repository.DoctorRepository;
import com.shiva.exception.ResourceNotFoundException;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
    private  DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
    }

	@Override
	public Doctor saveDoctor(Doctor doctor) {
	
		return doctorRepository.save(doctor);
	}
}
