package com.example.appointments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointments.models.Doctor;
import com.example.appointments.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {

    // Trae el repositorio del doctor
    @Autowired
    private DoctorRepository doctorRepository;

    // Lista con todos los doctores almacenados
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    // Devuelve solamente un doctor, el cual se busca por el ID
    public Doctor findById(long id) {
        return doctorRepository.findById(id);
    }

    // Permite agregar un nuevo Doctor a la BD
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

}
