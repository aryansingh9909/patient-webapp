package com.patientframework.repository;

import java.util.List;

import com.patientframework.domain.Patient;

import org.springframework.data.repository.CrudRepository;

public class PatientRepository extends CrudRepository<Patient, String> {

    List<Patient> getByName(String Name);
}