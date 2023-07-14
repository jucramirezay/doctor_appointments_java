package com.example.appointments.controller;

import com.example.appointments.models.Doctor;
import com.example.appointments.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.HashMap;

//@RestController
@Controller
public class DoctorController {

    @Autowired // Llamado a los servicios del Doctor
    private DoctorService doctorService;

    // Trae todos los doctores
    @GetMapping("/allDoctors")
    public String allDoctors(Model model) {
        List<Doctor> doctors = null;
        doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors); // Renderiza los doctores en la vista allDoctors.html
        return "allDoctors";
    }

    // Trae el doctor indicado por el id
    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable long id) {
        Doctor doctor = doctorService.findById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    // Llama el formulario del POST
    @GetMapping("/newDoctor")
    public String newDoctor(Model model) {
        model.addAttribute("message", "Doctor Form");
        return "newDoctor";
    }

    // Crea un nuevo doctor
    @PostMapping(value="/newDoctor", consumes = {"application/x-www-form-urlencoded"})
    public @ResponseBody HashMap<String, Object> addDoctor(Doctor doctor) {
        Doctor newDoctor = doctorService.addDoctor(doctor);
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "Successful");
        map.put("Data", newDoctor);
        return map;
    }

    // Elimina el doctor indicado por el id
    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>("Doctor eliminado", HttpStatus.OK);
    }

}
