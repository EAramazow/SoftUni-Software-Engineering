package com.workshoplab.repositories;

import com.workshoplab.entities.Company;
import com.workshoplab.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsAllBy();

    Employee findFirstByFirstNameAndLastNameAndAge(String firstName, String lastName, int age);

    List<Employee> findAllByAgeAfter(int age);

}
