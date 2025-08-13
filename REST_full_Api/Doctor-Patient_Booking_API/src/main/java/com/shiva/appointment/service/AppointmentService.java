package com.shiva.appointment.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.appointment.model.Appointment;
import com.shiva.appointment.repository.AppointmentRepository;
import com.shiva.doctor.model.Doctor;
import com.shiva.doctor.repository.DoctorRepository;
import com.shiva.dto.AppointmentRequest;
import com.shiva.dto.AppointmentResponse;
import com.shiva.exception.ConflictException;
import com.shiva.exception.InvalidRequestException;
import com.shiva.exception.ResourceNotFoundException;
import com.shiva.patients.model.Patient;
import com.shiva.patients.repository.PatientRepository;

@Service
public class AppointmentService {
    
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private  ModelMapper modelMapper; 

    public AppointmentResponse bookAppointment(AppointmentRequest request) {
        if (request.getDate().isBefore(LocalDate.now())) {
            throw new InvalidRequestException("Cannot book appointments in the past");
        }

        if (appointmentRepository.existsByDoctorIdAndDateAndTime(
                request.getDoctorId(), 
                request.getDate(), 
                request.getTime())) {
            throw new ConflictException("Appointment slot already booked");
        }

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        Appointment appointment = new Appointment();
        appointment.setDate(request.getDate());
        appointment.setTime(request.getTime());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return convertToResponse(savedAppointment);
    }

    public List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public List<AppointmentResponse> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    private AppointmentResponse convertToResponse(Appointment appointment) {
        AppointmentResponse response = new AppointmentResponse();
        response.setId(appointment.getId());
        response.setDate(appointment.getDate());
        response.setTime(appointment.getTime());
        response.setDoctorName(appointment.getDoctor().getName());
        response.setPatientName(appointment.getPatient().getName());
        return response;
    }
}
