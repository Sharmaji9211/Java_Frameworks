package com.shiva.patients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shiva.patients.model.Patient;
import com.shiva.patients.service.PatientsService;

@RestController
@RequestMapping("/patients") // Added base path
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientsService.addPatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // Fixed path variable
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) { // Changed to Long
        Patient patient = patientsService.getPatientById(id);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/{id}") // Fixed path variable
    public ResponseEntity<Void> deleteById(@PathVariable Long id) { // Changed to Long
        patientsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}