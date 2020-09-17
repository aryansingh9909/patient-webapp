package com.patient.converters;



import com.patient.commands.PatientForm;
import com.patient.domain.Patient;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class PatientFormToPatient implements Converter<PatientForm, Patient> {

    @Override
    public Patient convert(PatientForm patientForm) {
        Patient patient = new Patient();
        if (patientForm.getId() != null  && !StringUtils.isEmpty(patientForm.getId())) {
            patient.setId(new ObjectId(patientForm.getId()));
        }
        patient.setFname(patientForm.getFname());
        patient.setLname(patientForm.getLname());
        //patient.setAge(patientForm.getAge());
        patient.setDob(patientForm.getDob());
        patient.setGender(patientForm.getGender());
        return patient;
    }
}
