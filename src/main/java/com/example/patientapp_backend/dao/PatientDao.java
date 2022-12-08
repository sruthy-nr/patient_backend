package com.example.patientapp_backend.dao;

import com.example.patientapp_backend.model.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends CrudRepository<Patient,Integer> {

    @Query(value = "SELECT `id`, `doctor`, `image`, `name` FROM `patient` WHERE `name`= :name",nativeQuery = true)
    List<Patient> searchPatient(@Param("name") String name);
}
