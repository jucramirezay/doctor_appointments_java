package com.example.appointments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.appointments.services.UserService;
import com.example.appointments.models.User;

import java.util.List;
import java.util.HashMap;

@Controller
public class UserController {

    @Autowired // Llamado a los servicios
    private UserService userService;

    // Trae todos los usuarios
    @GetMapping("/allUsers")
    public String allUsers(Model model) {
        List<User> users = null;
        users = userService.findAll();
        model.addAttribute("users", users); // Renderiza los usuarios en la vista allUsers.html
        return "allUsers";
    }

    // Trae el usuario indicado por el id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Llama el formulario del POST
    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("message", "User Form");
        return "newUser";
    }

    // Crea un nuevo usuario
    @PostMapping(value = "/newUser", consumes = {"application/x-www-form-urlencoded"})
    public @ResponseBody HashMap<String, Object> addUser(User user) {
        User newUser = userService.addUser(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "Successful");
        map.put("Data", newUser);
        return map;
    }

    // Elimina el usuario indicado por el id
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
    }
}
