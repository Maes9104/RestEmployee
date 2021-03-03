package com.vass.employees.persistence.crud;

import com.vass.employees.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findByActive(boolean isActive);
    Optional<UserEntity> findByEmail(String email);
}
