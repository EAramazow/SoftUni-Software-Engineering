package com.automappingobjects.repositories;

import com.automappingobjects.entities.Employee;
import com.automappingobjects.entities.dto.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<EmployeeDto> findByBirthdayBeforeOrderBySalaryDesc(LocalDate beforeYear);
}
