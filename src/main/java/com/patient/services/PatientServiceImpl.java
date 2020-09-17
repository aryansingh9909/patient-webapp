package com.patient.services;

import com.patient.commands.PatientForm;
import com.patient.converters.PatientFormToPatient;
import com.patient.domain.Patient;
import com.patient.repositories.PatientRepository;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private PatientFormToPatient patientFormToPatient;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, PatientFormToPatient patientFormToPatient) {
        // public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        this.patientFormToPatient = patientFormToPatient;
    }

    @Override
    public List<Patient> listAll() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add); // fun with Java 8
        return patients;
    }

    @Override
    public Patient getById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient saveOrUpdate(Patient patient) {
        patient.setAlphaid(RandomStringUtils.randomAlphanumeric(16));
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public void delete(String id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient saveOrUpdatePatientForm(PatientForm patientForm) {
        Patient savedPatient = saveOrUpdate(patientFormToPatient.convert(patientForm));
        System.out.println("Saved Patient Id: " + savedPatient.getId());
        return savedPatient;
    }

    @Override
    public List<Patient> getByFnameAndLname(String fname, String lname) {
        List<Patient> patients = new ArrayList<>();
        patientRepository.getByFnameAndLname(fname, lname).forEach(patients::add);
        return patients;

    }

    @Override
    public void deleteAll() {
    }

    /*@Override
    public List<Patient> getByName(String Name) {
        List<Patient> patients = new ArrayList<>();
        patientRepository.getByName(Name).forEach(patients::add); 
        return patients;
    }*/

      
}
