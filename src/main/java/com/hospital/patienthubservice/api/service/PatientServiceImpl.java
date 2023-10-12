package com.hospital.patienthubservice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.hospital.patienthubservice.api.entity.Patient;
import com.hospital.patienthubservice.api.exception.PatientNotFoundException;
import com.hospital.patienthubservice.api.repository.PatientRepository;

public class PatientServiceImpl implements PatientService{
	@Autowired
    private PatientRepository patientRepository;

    @Cacheable(value = "patients", key = "#id")
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
            .orElseThrow(() -> new PatientNotFoundException("Patient not found"));
    }

    @CachePut(value = "patients", key = "#result.id")
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @CachePut(value = "patients", key = "#patient.id")
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @CacheEvict(value = "patients", key = "#id")
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
