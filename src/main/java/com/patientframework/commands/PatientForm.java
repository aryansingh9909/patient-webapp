package com.patientframework.commands;

import org.bson.types.ObjectId;

public class PatientForm {
    private ObjectId _id;
    private String fname;
    private String lname;
    private String gender;
    private Object dob;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

	public Object getDob() {
		return dob;
	}

	public void setDob(Object dob) {
		this.dob = dob;
	}

    
}