package com.hospital.patienthubservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hospital.patienthubservice.api.entity.Patient;
import com.hospital.patienthubservice.api.service.PatientService;

public class PatientController {
   
	 @Autowired
	    private PatientService patientService;
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Object> getPatient(@PathVariable Long id) {
	        return ResponseEntity.ok(patientService.getPatientById(id));
	    }

	    @PostMapping
	    public ResponseEntity<Object> createPatient(@RequestBody Patient patient) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createPatient(patient));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Object> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
	        patient.setId(id);
	        return ResponseEntity.ok(patientService.updatePatient(patient));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
	        patientService.deletePatient(id);
	        return ResponseEntity.noContent().build();
	    }
	 
}
