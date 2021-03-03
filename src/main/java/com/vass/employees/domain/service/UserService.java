package com.vass.employees.domain.service;

import com.vass.employees.domain.User;
import com.vass.employees.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public List<User> getActiveUsers() {
        return userRepository.getActiveUsers();
    }

    public Optional<User> getUser(int idUser) {
        return userRepository.getUser(idUser);
    }

    public Optional<User> getUserByMail(String email) {
        return userRepository.getUserByMail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean inactivateUser(int idUser) {
        return userRepository.inactivateUser(idUser);
    }

}
