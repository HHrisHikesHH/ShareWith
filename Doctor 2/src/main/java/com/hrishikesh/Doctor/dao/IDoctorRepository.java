package com.hrishikesh.Doctor.dao;

import com.hrishikesh.Doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByid(Integer id);
    @Modifying      // to mark delete or update query
    @Query(value = "DELETE FROM Doctor d WHERE d.name = :name")       // it will delete all the record with specific name
    void  deleteByName(@Param("name") String name);
    Doctor findByName(String name);

//    Integer deleteByName(String firstName);
//    Doctor findByName(String name);
}
