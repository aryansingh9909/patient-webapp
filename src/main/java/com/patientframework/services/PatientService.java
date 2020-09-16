package com.patientframework.services;

import java.util.List;

import com.patientframework.commands.PatientForm;
import com.patientframework.domain.Patient;

public interface PatientService {
    
    List<Patient> listAll();

    Patient getById(String id);

    Patient saveOrUpdate(Patient patient);

    List<Patient> getByName(String Name);

    void delete(String id);

    Patient saveOrUpdatePatientForm(PatientForm patientForm);
}