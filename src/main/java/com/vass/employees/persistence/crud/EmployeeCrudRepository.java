package com.vass.employees.persistence.crud;

import com.vass.employees.persistence.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeCrudRepository extends CrudRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findByIdBoss(int idBoss);
}
