package com.automappingobjects.Demo;

import com.automappingobjects.Demo.dto.EmployeeDTO;
import com.automappingobjects.Demo.dto.ManagerDTO;
import com.automappingobjects.Demo.entities.Address;
import com.automappingobjects.Demo.entities.Employee;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MapperMain {
    public static void main(String[] args) {
        ModelMapper mapper = new ModelMapper();
        Address address = new Address("Oborishte", 1, "Sofia", "Bulgaria");

        Employee manager = new Employee("Mr.", "Manager"
        , BigDecimal.TEN, LocalDate.now(), address, true);

        Employee first = new Employee("First", "Employee"
                , BigDecimal.ZERO, LocalDate.now(), address, true);

        Employee second = new Employee("Second", "Employee"
                , BigDecimal.ONE, LocalDate.now(), address, true);

        manager.addEmployee(first);
        manager.addEmployee(second);

        ManagerDTO employeeDTO = mapper.map(manager , ManagerDTO.class);

        System.out.println(employeeDTO);
    }
}
