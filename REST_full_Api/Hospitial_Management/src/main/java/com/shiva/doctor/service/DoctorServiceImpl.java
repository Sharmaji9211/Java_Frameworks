package com.shiva.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.doctor.model.Doctor;
import com.shiva.doctor.repository.Repository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
  @Autowired
  private Repository repository;

  public void addDoctor(Doctor doctor) {
	repository.save(doctor);
  }
  public Doctor getDoctorById(int did) {
	
	return repository.findById(did).orElse(null);
  }

  public void deleteById(int did) {
	  repository.deleteById(did);
  }
	
}
