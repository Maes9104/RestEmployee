package com.vass.employees.persistence;

import com.vass.employees.domain.Employee;
import com.vass.employees.domain.repository.EmployeeRepository;
import com.vass.employees.persistence.crud.EmployeeCrudRepository;
import com.vass.employees.persistence.entity.EmployeeEntity;
import com.vass.employees.persistence.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeEntityRepository implements EmployeeRepository {
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public List<Employee> getAll(){
        List<EmployeeEntity> employeeEntities = (List<EmployeeEntity>) employeeCrudRepository.findAll();
        return mapper.toEmployees(employeeEntities);
    }

    @Override
    public List<Employee> getByBossId(int idBoss){
        List<EmployeeEntity> employeeEntities = employeeCrudRepository.findByIdBoss(idBoss);
        return mapper.toEmployees(employeeEntities);
    }

    @Override
    public Optional<Employee> getEmployee(int idEmployee){
        Optional<EmployeeEntity> employee = employeeCrudRepository.findById(idEmployee);
        return employee.map(emp -> mapper.toEmployee(emp));
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeEntity employeeEntity = mapper.toEmployeeEntity(employee);
        return mapper.toEmployee(employeeCrudRepository.save(employeeEntity));
    }

    @Override
    public void delete(int idEmployee){
        employeeCrudRepository.deleteById(idEmployee);
    }
}
