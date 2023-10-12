package com.hospital.patienthubservice.api.service;

import com.hospital.patienthubservice.api.entity.Patient;

public interface PatientService {

	void deletePatient(Long id);

	Object updatePatient(Patient patient);

	Object getPatientById(Long id);

	Object createPatient(Patient patient);
	

	
	
}
