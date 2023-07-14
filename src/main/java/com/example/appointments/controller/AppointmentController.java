package com.example.appointments.controller;

import com.example.appointments.models.Appointment;
import com.example.appointments.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;

@Controller
public class AppointmentController {

    @Autowired // Llamado a los servicios del appointment
    private AppointmentService appointmentService;

    // Trae todas las citas
    @GetMapping("/allAppointments")
    public String allAppointments(Model model) {
        List<Appointment> appointments = null;
        appointments = appointmentService.findAll();
        model.addAttribute("appointments", appointments); // Renderiza las citas en la vista allAppointments.html
        return "allAppointments";
    }

    // Trae la cita indicado por el id
    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable long id) {
        Appointment appointment = appointmentService.findById(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    // Llama el formulario del POST
    @GetMapping("/newAppointment")
    public String newAppointment(Model model) {
        model.addAttribute("message", "Appointment Form");
        return "newAppointment";
    }

    // Crea una nueva cita
    @PostMapping(value = "/newAppointment", consumes = {"application/x-www-form-urlencoded"})
    public @ResponseBody HashMap<String, Object> addAppointment(Appointment appointment) {
        Appointment newAppointment = appointmentService.addAppointment(appointment);
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "Successful");
        map.put("Data", appointment);
        return map;
    }

    // Elimina la cita indicada por el id
    @DeleteMapping("/deleteAppointment/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Appointment eliminado", HttpStatus.OK);
    }

}
