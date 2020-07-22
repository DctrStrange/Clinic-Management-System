package com.clinicmanagement.thyroid.diesease;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "diesease_thyroid")

public class ThyroidDiesease {
	
	@Id
	@GeneratedValue
	private int id;
	private int patientID;
	private int sampleID;
	private float t3=0;
	private float t4=0;
	private float tsh=0;
	private float referencerangelowert3=(float) 0.6;
	private float referencerangehighert3=(float) 2.0;
	private float referencerangelowert4=(float) 5.0;
	private float referencerangehighert4=(float) 13.0;
	private float referencerangelowertsh=(float) 0.4;
	private float referencerangehighertsh=(float) 7.0;
	private String testResult="";
	
	
	public int getpatientID() {
		return patientID;
	}
	public void setpatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getsampleID() {
		return sampleID;
	}
	public void setsampleID(int sampleID) {
		this.sampleID = sampleID;
	}
	public float getT3() {
		return t3;
	}
	public void setT3(float t3) {
		this.t3 = t3;
	}
	public float getT4() {
		return t4;
	}
	public void setT4(float t4) {
		this.t4 = t4;
	}
	public float getTsh() {
		return tsh;
	}
	public void setTsh(float tsh) {
		this.tsh = tsh;
	}
	public float getReferencerangelowert3() {
		return referencerangelowert3;
	}
	public float getReferencerangelowert4() {
		return referencerangelowert4;
	}
	public float getReferencerangelowertsh() {
		return referencerangelowertsh;
	}
	public float getReferencerangehighert3() {
		return referencerangehighert3;
	}
	public float getReferencerangehighert4() {
		return referencerangehighert4;
	}
	public float getReferencerangehighertsh() {
		return referencerangehighertsh;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	
}