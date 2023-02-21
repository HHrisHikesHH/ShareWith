package com.hrishikesh.Doctor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_patient")
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer id;

    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "patient_disease")
    private String disease;
    @Column(name = "admit_time")
    private Timestamp admitTime = new Timestamp(System.currentTimeMillis());

    @JoinColumn(name = "doctor_id")
    @ManyToOne
    private Doctor doctor;
}
