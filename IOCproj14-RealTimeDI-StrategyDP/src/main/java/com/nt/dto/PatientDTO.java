package com.nt.dto;

import java.io.Serializable;

public class PatientDTO implements Serializable {
       private String Patient_Name;
       private String Patient_Address;
       private String Hospital_Name;
       private int Patient_Age;
       private int No_Day;
       //getters & setters
	public String getPatient_Name() {
		return Patient_Name;
	}
	public void setPatient_Name(String patient_Name) {
		Patient_Name = patient_Name;
	}
	public String getPatient_Address() {
		return Patient_Address;
	}
	public void setPatient_Address(String patient_Address) {
		Patient_Address = patient_Address;
	}
	public String getHospital_Name() {
		return Hospital_Name;
	}
	public void setHospital_Name(String hospital_Name) {
		Hospital_Name = hospital_Name;
	}
	public int getPatient_Age() {
		return Patient_Age;
	}
	public void setPatient_Age(int patient_Age) {
		Patient_Age = patient_Age;
	}
	public int getNo_Day() {
		return No_Day;
	}
	public void setNo_Day(int no_Day) {
		No_Day = no_Day;
	}
}
