package com.automappingobjects.services;

import com.automappingobjects.entities.Employee;
import com.automappingobjects.entities.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> findOneById(int id);

    void save (Employee employee);

    List<EmployeeDto> findEmployeesBornBefore(int year);

    List<Employee> findAll();
}