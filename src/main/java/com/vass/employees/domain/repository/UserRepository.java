package com.vass.employees.domain.repository;

import com.vass.employees.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    List<User> getActiveUsers();
    Optional<User> getUser(int idUser);
    Optional<User> getUserByMail(String email);
    User save(User user);
    boolean inactivateUser(int idUser);
}
