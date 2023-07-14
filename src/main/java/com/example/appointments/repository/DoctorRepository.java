package com.example.appointments.repository;

import com.example.appointments.models.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    List<Doctor> findAll();
    Doctor findById(long id);

}
