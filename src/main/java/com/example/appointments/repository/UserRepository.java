package com.example.appointments.repository;

import com.example.appointments.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    User findById(long id);

}
