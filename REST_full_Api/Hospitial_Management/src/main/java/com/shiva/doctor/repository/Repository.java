package com.shiva.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.doctor.model.Doctor;

public interface Repository extends JpaRepository<Doctor, Integer> {

}
