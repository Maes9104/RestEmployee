package com.vass.employees.persistence;

import com.vass.employees.domain.User;
import com.vass.employees.domain.repository.UserRepository;
import com.vass.employees.persistence.crud.UserCrudRepository;
import com.vass.employees.persistence.entity.UserEntity;
import com.vass.employees.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserEntityRepository implements UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.toUsers((List<UserEntity>) userCrudRepository.findAll());
    }

    @Override
    public List<User> getActiveUsers() {
        return userMapper.toUsers(userCrudRepository.findByActive(true));
    }

    @Override
    public Optional<User> getUser(int idUser) {
        return userCrudRepository.findById(idUser).map(userEntity -> userMapper.toUser(userEntity));
    }

    @Override
    public Optional<User> getUserByMail(String email) {
        return userCrudRepository.findByEmail(email).map(user -> userMapper.toUser(user));
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toUserEntity(user);
        return userMapper.toUser(userCrudRepository.save(userEntity));
    }

    @Override
    public boolean inactivateUser(int idUser) {
        Optional<UserEntity> userEntity = userCrudRepository.findById(idUser);
        return userEntity.map(user -> {
            user.setActive(false);
            return true;
        }).orElse(false);
    }
}
