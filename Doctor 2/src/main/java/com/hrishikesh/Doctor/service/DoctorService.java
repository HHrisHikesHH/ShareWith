package com.hrishikesh.Doctor.service;

import com.hrishikesh.Doctor.dao.IDoctorRepository;
import com.hrishikesh.Doctor.model.Doctor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private IDoctorRepository repository;

    public List<Doctor> findAll(Integer id, String exp) {

        if(id == null && exp == null)
            return repository.findAll();
        else if(id != null && exp == null){
            List<Doctor> list= new ArrayList<>();
            list.add(findById(id));
            return list;
        } else if (id == null) {
            List<Doctor> temp = repository.findAll();
            List<Doctor> list = new ArrayList<>();
            for (Doctor doc: temp) {
                if(Integer.parseInt(doc.getExp()) >= Integer.parseInt(exp)) list.add(doc);
            }
            return list;
        }else {
            List<Doctor> temp = repository.findAll();
            List<Doctor> list = new ArrayList<>();
            for (Doctor doc: temp) {
                if(Integer.parseInt(doc.getExp()) >= Integer.parseInt(exp) && doc.getId().equals(id)) list.add(doc);
            }
            return list;
        }
    }

    public void save(JSONObject doctor) {
        String name = (String)doctor.get("name");
        String specs = (String)doctor.get("specs");
        String title = "";
        String exp = "not available";
        if(doctor.has("title")){
            title = (String)doctor.get("title") + ". ";
        }
        if(doctor.has("exp")){
            exp = (String)doctor.get("exp");
        }
        name += title;
        Doctor newDoc = new Doctor(name, specs, exp);
        repository.save(newDoc);
    }

    private Doctor findById(Integer id) {
        return repository.findByid(id);
    }

    public boolean deleteByName(String name) {
        List<Doctor> list= this.findAll(null, null);
        for(Doctor doctor: list) {
            if(doctor.getName().equals(name)) {
                this.deleteById(doctor.getId());
                return false;
            }
        }
        return true;
    }

    public boolean deleteById(Integer id) {
        if(this.findById(id) != null) {
            repository.deleteById(id);
            return false;
        }
        else return true;
    }

    public boolean update(Doctor newDoctor) {
        List<Doctor> list= this.findAll(null, null);
        Doctor temp = new Doctor();
        for(Doctor doctor: list) {
            if(doctor.getName().equals(newDoctor.getName())) {
                temp.setId(doctor.getId());
                if(newDoctor.getName() != null) temp.setName(newDoctor.getName());
                if(newDoctor.getSpecs() != null) temp.setSpecs(newDoctor.getSpecs());
                if(newDoctor.getExp() != null) temp.setExp(newDoctor.getExp());
                this.deleteByName(doctor.getName());
                repository.save(temp);
                return false;
            }
        }
        return true;
    }
}
