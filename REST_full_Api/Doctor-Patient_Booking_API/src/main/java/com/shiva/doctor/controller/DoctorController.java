package com.shiva.doctor.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shiva.doctor.model.Doctor;
import com.shiva.doctor.service.DoctorService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/doctors")
@Tag(name = "Doctors", description = "Doctor management APIs")
public class DoctorController {

    @Autowired
    private DoctorService doctorService; 
   
    
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> listOfDoctors = doctorService.getAllDoctors(); 
        return ResponseEntity.status(HttpStatus.OK).body(listOfDoctors); 
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id); 
        if (doctor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(doctor);
    }
}
