package com.hrishikesh.Doctor.service;

import com.hrishikesh.Doctor.dao.IPatientRepository;
import com.hrishikesh.Doctor.model.Doctor;
import com.hrishikesh.Doctor.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    IPatientRepository repository;
    @Autowired
    DoctorService service;

    public ResponseEntity<String> findAll(String doctorName, String patientName, String password) {
        List<Doctor> list = new ArrayList<>();
        if(doctorName == null && patientName == null && password != null){
            if(password.equals("password")) return new ResponseEntity<>(repository.findAll().toString(), HttpStatus.OK);
            return new ResponseEntity<>(list.toString(), HttpStatus.OK);
        }
        else if (patientName != null && doctorName != null){
            return new ResponseEntity<>("Permission Denied", HttpStatus.FORBIDDEN);
        }
        else if (doctorName != null) {
            List<Doctor> temp = service.findAll(null, null);
            for(Doctor doctor: temp) {
                if(doctor.getName().equals(doctorName)) {
                    list.add(doctor);
                }
            }
            return new ResponseEntity<>(list.toString(), HttpStatus.OK);
        }else if (patientName != null){
            List<Patient> temp = repository.findAll();
            for(Patient patient: temp) {
                if(patient.getPatientName().equals(patientName)) {
                    return new ResponseEntity<>(patient.toString(), HttpStatus.OK);
                }
            }
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>("Please enter valid params", HttpStatus.NOT_FOUND);
    }
}
