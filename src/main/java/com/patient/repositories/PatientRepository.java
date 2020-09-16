package com.patient.repositories;

import java.util.List;

import com.patient.domain.Patient;

import org.springframework.data.repository.CrudRepository;


public interface PatientRepository extends CrudRepository<Patient, String>{

    List<Patient> getByName(String Name);
}
