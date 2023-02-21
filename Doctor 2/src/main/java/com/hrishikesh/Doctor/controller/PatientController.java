package com.hrishikesh.Doctor.controller;

import com.hrishikesh.Doctor.service.PatientService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {
    @Autowired
    PatientService service;
    @GetMapping("get")
    private ResponseEntity<String> findAll(@Nullable @RequestParam String doctorName,
                                           @Nullable @RequestParam String patientName, @Nullable String adminPassword){
        return service.findAll(doctorName, patientName, adminPassword);
    }
}
