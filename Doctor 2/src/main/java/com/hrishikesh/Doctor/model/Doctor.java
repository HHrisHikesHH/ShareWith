package com.hrishikesh.Doctor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_doctor")
public class Doctor  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer id;
    @Column(name = "doctor_name")
    private String name;
    @Column(name = "doctor_speciality")
    private String specs;
    @Column(name = "doctor_experience")
    private String exp;

    public Doctor(String name, String specs, String exp) {
        this.name = name;
        this.specs = specs;
        this.exp = exp;
    }
}
