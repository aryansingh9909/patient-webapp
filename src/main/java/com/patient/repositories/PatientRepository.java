package com.patient.repositories;

import java.util.List;

import com.patient.domain.Patient;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepository extends CrudRepository<Patient, String>{

   @Query("{'$or':[ {'fname':?0}, {'lname':?1} ] }")
    List<Patient> getByFnameAndLname(String fname, String lname);

    //List<Patient> getByName(String Name); 
    
}
