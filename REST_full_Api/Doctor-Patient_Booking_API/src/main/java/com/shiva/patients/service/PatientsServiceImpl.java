package com.shiva.patients.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.patients.model.Patient;
import com.shiva.patients.repository.PatientRepository;

@Service
public class PatientsServiceImpl implements PatientsService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient getPatientById(Long id) { // Changed to Long
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) { // Changed to Long
        patientRepository.deleteById(id);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}