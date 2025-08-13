package com.shiva.patients.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.patients.model.Patients;

public interface Patientsrepository extends JpaRepository<Patients, Integer>  {

}
