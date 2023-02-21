package com.hrishikesh.Doctor.util;

import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Validation {
    public static List<String> validate(String doctor) {
        List<String> errors = new ArrayList<>();
        JSONObject json = new JSONObject(doctor);
        if(!json.has("name")) errors.add("name");
        if(!json.has("specs")) errors.add("specs");
        return errors;
    }
}
