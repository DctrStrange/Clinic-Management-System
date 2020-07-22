package com.clinicmanagement.thyroid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicmanagement.thyroid.diesease.ThyroidDiesease;
public interface ThyroidDieseaseRepository extends JpaRepository<ThyroidDiesease, Integer>{

}
