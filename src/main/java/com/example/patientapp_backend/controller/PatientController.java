package com.example.patientapp_backend.controller;

import com.example.patientapp_backend.dao.PatientDao;
import com.example.patientapp_backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PatientController {
    @Autowired
    private PatientDao dao;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String Homepage(){
        return "Welcome to my website";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Map<String, String> AddPatient(@RequestBody Patient p){
        dao.save(p);
        HashMap<String, String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/view")
    public List<Patient> ViewPatient(){

        return (List<Patient>) dao.findAll();
    }

    @CrossOrigin("*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<Patient> SearchPatient(@RequestBody Patient p){

        String name=String.valueOf(p.getName());
        System.out.println(name);
        return (List<Patient>) dao.searchPatient(p.getName());
    }

    @CrossOrigin("*")
    @PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public Map<String,String> DeletePatient(@RequestBody Patient p){
        String pid=String.valueOf(p.getId());
        System.out.println(pid);
        dao.deletePatient(p.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

}
