package com.example.appointments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointments.models.Appointment;
import com.example.appointments.repository.AppointmentRepository;


import java.util.List;

@Service
public class AppointmentService {

    // Trae el repositorio del appointment
    @Autowired
    private AppointmentRepository appointmentRepository;

    // Lista con todos los appointments almacenados
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    // Devuelve solamente un appointment, el cual se busca por el ID
    public Appointment findById(long id) {
        return appointmentRepository.findById(id);
    }

    // Permite agregar un nuevo appointment a la BD
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

}
