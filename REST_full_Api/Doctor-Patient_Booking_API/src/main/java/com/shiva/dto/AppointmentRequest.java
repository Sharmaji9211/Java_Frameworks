package com.shiva.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;


public class AppointmentRequest {
  
	 @Schema(description = "Doctor ID", example = "1", required = true)
	    private Long doctorId;
	    
	    @Schema(description = "Patient ID", example = "1", required = true)
	    private Long patientId;
	    
	    @Schema(description = "Appointment date (YYYY-MM-DD)", example = "2025-12-31", required = true)
	    private LocalDate date;
	    
	    @Schema(description = "Appointment time (HH:MM)", example = "14:30", required = true)
	    private LocalTime time;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	
}
