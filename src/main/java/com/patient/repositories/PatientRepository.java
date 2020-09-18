package com.patient.repositories;

import java.util.List;

import com.patient.domain.Patient;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepository extends CrudRepository<Patient, String>{
    
    //for finding exact match of  fname and lname
   /*@Query("{'$or':[ {'fname':?0}, {'lname':?1} ] }")
    List<Patient> getByFnameAndLname(String fname, String lname);*/

    //works as  %LIKE% of SQL
    @Query(value = "{$or:[{fname:{$regex:?0,$options:'i'}},{lname:{$regex:?1,$options:'i'}}]}")
    List<Patient> getByFnameAndLname(String fname, String lname);

    //query of get only by name if only name field is there
    //List<Patient> getByName(String Name); 
    
}
