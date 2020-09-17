package com.patient.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

//import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;


@Document(collection = "patient")
public class Patient {
    @Id
    private ObjectId _id;
    private String alphaid;
    private String fname;
    private String lname;
    private int age;
    private String gender;
    //private Address address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }



   public int getAge() {
        return age;
    }

    /*public void setAge(BigDecimal age) {
        this.age = age;
    }*/
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        
        this.age = Period.between(dob, LocalDate.now()).getYears();
        this.dob = dob;
    }
}
