package com.clinicmanagement.thyroid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicmanagement.thyroid.diesease.ThyroidDiesease;
import com.clinicmanagement.thyroid.repository.ThyroidDieseaseRepository;



@Service
public class ThyroidDieseaseService {
	@Autowired
	private ThyroidDieseaseRepository repository;
	
	public ThyroidDiesease saveTestDetails(ThyroidDiesease testDetails) {
		return repository.save(testDetails);
	}
	
	public List<ThyroidDiesease> saveMultipleTestDetails(List<ThyroidDiesease> allTestDetails) {
		return repository.saveAll(allTestDetails);
	}
	
	public List<ThyroidDiesease> getAllTestDetails(){
		return repository.findAll();
	}
	
	public ThyroidDiesease getTestDetailsById(int Serial_No){
		return repository.findById(Serial_No).orElse(null);
	}
	
	public ThyroidDiesease updateTestDetailsById(ThyroidDiesease updateDieseaseTestDetails, int serialNo) {
		ThyroidDiesease existingTest=repository.findById(serialNo).orElse(null);
		existingTest.setT3(updateDieseaseTestDetails.getT3());
		existingTest.setT4(updateDieseaseTestDetails.getT4());
		existingTest.setTsh(updateDieseaseTestDetails.getTsh());
		return repository.save(existingTest);
	}
	
	public ThyroidDiesease updateDieseaseTestResult(int Serial_No) {
		ThyroidDiesease gotDieseaseReport=repository.findById(Serial_No).orElse(null);
		int flag=0;
		if(gotDieseaseReport.getReferencerangelowert3()<gotDieseaseReport.getT3() && gotDieseaseReport.getT3()<gotDieseaseReport.getReferencerangehighert3()){
			flag=0;
			if(gotDieseaseReport.getReferencerangelowert4()<gotDieseaseReport.getT4() && gotDieseaseReport.getT4()<gotDieseaseReport.getReferencerangehighert4()) {
				flag=0;
				if(gotDieseaseReport.getReferencerangelowertsh()<gotDieseaseReport.getTsh() && gotDieseaseReport.getTsh()<gotDieseaseReport.getReferencerangehighertsh()){
					flag=0;
				}
				else {
					flag=1;
				}
			}
			else {
				flag=1;
			}
		}
		else {
			flag=1;
		}
		if(flag==0) {
			gotDieseaseReport.setTestResult("Negative");
		}
		else {
			gotDieseaseReport.setTestResult("Positive");
		}
		return repository.save(gotDieseaseReport);
	}
}
