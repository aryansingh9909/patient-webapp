package com.patient.commands;

//import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by jt on 1/10/17.
 */
public class PatientForm {
    
    private String id;
    private String alphaid;
    private String fname;
    private String lname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private Integer age;
    //private BigDecimal Age;
    private String Gender;
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    /*public BigDecimal getAge() {
        return Age;
    }

    public void setAge(BigDecimal Age) {
        this.Age = Age;
    }*/

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAlphaid() {
        return alphaid;
    }

    public void setAlphaid(String alphaid) {
        this.alphaid = alphaid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
