package com.shiva.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;

public class AppointmentResponse {
	 @Schema(description = "Appointment ID", example = "100")
	    private Long id;
	    
	    @Schema(description = "Appointment date", example = "2025-12-31")
	    private LocalDate date;
	    
	    @Schema(description = "Appointment time", example = "14:30")
	    private LocalTime time;
	    
	    @Schema(description = "Doctor's name", example = "Dr. Smith")
	    private String doctorName;
	    
	    @Schema(description = "Patient's name", example = "John Doe")
	    private String patientName;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public String getDoctorName() {
			return doctorName;
		}
		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}
		public String getPatientName() {
			return patientName;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}
		
	}
