package com.vass.employees.persistence.mapper;

import com.vass.employees.domain.Employee;
import com.vass.employees.persistence.entity.EmployeeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "userEntity", target = "user")
    Employee toEmployee(EmployeeEntity employeeEntity);

    List<Employee> toEmployees(List<EmployeeEntity> employeeEntities);

    @InheritInverseConfiguration
    EmployeeEntity toEmployeeEntity(Employee employee);
}
