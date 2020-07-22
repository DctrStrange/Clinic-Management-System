package com.clinicmanagement.thyroid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinicmanagement.thyroid.diesease.ThyroidDiesease;
import com.clinicmanagement.thyroid.service.ThyroidDieseaseService;


@RestController
public class ThyroidDieseaseController {

	@Autowired
	private ThyroidDieseaseService service;
	
	@PostMapping("/addTestDetails")
	public ThyroidDiesease addTestDetails(@RequestBody ThyroidDiesease product) {
		return service.saveTestDetails(product);
	}
	
	@PostMapping("/addMultipleTestDetails")
	public List<ThyroidDiesease> addMultipleTestDetails(@RequestBody List<ThyroidDiesease> products) {
		return service.saveMultipleTestDetails(products);
	}
	
	@GetMapping("/allTestDetails")
	public List<ThyroidDiesease> findAllTestDetails(){
		return service.getAllTestDetails();
	}
	
	@GetMapping("/testDetails/{serialNo}")
	public ThyroidDiesease findTestDetailsById(@PathVariable int serialNo) {
		return service.getTestDetailsById(serialNo);
	}
	
	@PutMapping("/updateTestDetails/{serialNo}")
	public ThyroidDiesease updateTestDetails(@RequestBody ThyroidDiesease updateTestDetails, @PathVariable int serialNo) {
		return service.updateTestDetailsById(updateTestDetails, serialNo);
	}
	
	@PutMapping("/updateTestResult/{serialNo}")
	public void updateTestResult(@PathVariable int serialNo) {
		service.updateDieseaseTestResult(serialNo);
	}
}
