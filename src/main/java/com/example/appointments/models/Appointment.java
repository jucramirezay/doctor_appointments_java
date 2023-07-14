package com.example.appointments.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Revisar ya que este atributo es una foreign key de la tabla usuario
    @Column
    private Integer idNumber;

    @Column
    private String specialty;

}
