package com.vass.employees.domain.repository;

import com.vass.employees.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> getAll();
    List<Employee> getByBossId(int idBoss);
    Optional<Employee> getEmployee(int employeeId);
    Employee save(Employee employee);
    void delete(int employeeId);
}
