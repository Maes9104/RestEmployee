package com.vass.employees.web.controller;

import com.vass.employees.domain.User;
import com.vass.employees.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<List<User>> getActiveUsers() {
        return new ResponseEntity<>(userService.getActiveUsers(), HttpStatus.OK);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> getUser(@PathVariable("idUser") int idUser) {
        return userService.getUser(idUser)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("mail/{email}")
    public ResponseEntity<User> getUserByMail(@PathVariable("email") String email) {
        return userService.getUserByMail(email)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity inactivateUser(@PathVariable("idUser") int idUser) {
        return userService.inactivateUser(idUser) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }




}
