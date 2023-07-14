package com.example.appointments.services;

import com.example.appointments.models.User;
import com.example.appointments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // Trae el repositorio del usuario
    @Autowired
    private UserRepository userRepository;

    // Lista todos los usuarios
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Lista solamente un usuario, el indicado por el id
    public User findById(long id) {
        return userRepository.findById(id);
    }

    // Permite agregar un nuevo usuario a la BD
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Se elimina el usuario indicado por el id
    public void deleteUser(long id) { userRepository.deleteById(id); }

}
