package com.shiva.appointment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shiva.appointment.service.AppointmentService;
import com.shiva.dto.AppointmentRequest;
import com.shiva.dto.AppointmentResponse;
import com.shiva.exception.InvalidRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/appointments")
@Tag(name = "Appointments", description = "Appointment management APIs")
public class AppointmentController {

    private  AppointmentService appointmentService;

	 @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Operation(summary = "Book a new appointment", responses = {
        @ApiResponse(responseCode = "201", description = "Appointment created"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "Doctor or patient not found"),
        @ApiResponse(responseCode = "409", description = "Time slot already booked")
    })
    @PostMapping
    public ResponseEntity<AppointmentResponse> bookAppointment(
            @Valid @RequestBody AppointmentRequest request) {
        return new ResponseEntity<>(
            appointmentService.bookAppointment(request), 
            HttpStatus.CREATED
        );
    }

    @Operation(summary = "Get appointments by doctor or patient")
    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAppointments(
            @Parameter(description = "Doctor ID", example = "1")
            @RequestParam(required = false) Long doctorId,
            
            @Parameter(description = "Patient ID", example = "1")
            @RequestParam(required = false) Long patientId) {
        
        if (doctorId != null) {
            return ResponseEntity.ok(
                appointmentService.getAppointmentsByDoctor(doctorId)
            );
        } 
        else if (patientId != null) {
            return ResponseEntity.ok(
                appointmentService.getAppointmentsByPatient(patientId)
            );
        } 
        else {
            throw new InvalidRequestException("Specify either doctorId or patientId");
        }
    }
}