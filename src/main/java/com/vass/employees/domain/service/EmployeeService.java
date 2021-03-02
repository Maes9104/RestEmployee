package com.vass.employees.domain.service;

import com.vass.employees.domain.Employee;
import com.vass.employees.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    public List<Employee> getByBossId(int idBoss) {
        return employeeRepository.getByBossId(idBoss);
    }

    public Optional<Employee> getEmployee (int employeeId) {
        return employeeRepository.getEmployee(employeeId);
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public boolean delete(int employeeId) {
        return getEmployee(employeeId).map(employee -> {
            employeeRepository.delete(employeeId);
            return true;
        }).orElse(false);
    }
}
