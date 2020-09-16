package com.patient.services;



import com.patient.commands.PatientForm;
import com.patient.domain.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> listAll();

    Patient getById(String id);

    Patient saveOrUpdate(Patient patient);

    List<Patient> getByName(String Name);

    void delete(String id);

    Patient saveOrUpdatePatientForm(PatientForm patientForm);
}
