package com.hrishikesh.Doctor.dao;

import com.hrishikesh.Doctor.model.Doctor;
import com.hrishikesh.Doctor.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

}
