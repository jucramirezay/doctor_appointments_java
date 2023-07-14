package com.example.appointments.repository;

import com.example.appointments.models.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long>  {

    List<Appointment> findAll();
    Appointment findById(long id);

}
