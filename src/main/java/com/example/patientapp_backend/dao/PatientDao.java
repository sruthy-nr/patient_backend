package com.example.patientapp_backend.dao;

import com.example.patientapp_backend.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientDao extends CrudRepository<Patient,Integer> {
}
