package com.hospital.patienthubservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.patienthubservice.api.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
