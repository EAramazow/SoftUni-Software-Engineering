package com.automappingobjects;

import com.automappingobjects.entities.Employee;
import com.automappingobjects.entities.dto.CustomDto;
import com.automappingobjects.entities.dto.EmployeeDto;
import com.automappingobjects.services.EmployeeService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private EmployeeService employeeService;

    @Autowired
    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {


        this.employeeService.findEmployeesBornBefore(1990)
                .forEach(System.out::println);

        List<Employee> all = this.employeeService.findAll();

        ModelMapper mapper = new ModelMapper();

        TypeMap<Employee, CustomDto> employeeToCustom = mapper.typeMap(Employee.class, CustomDto.class);

        Converter<Employee, Integer> getLastNameLength =
                ctx -> ctx.getSource() == null ? null : ctx.getSource().getLastName().length();

        employeeToCustom.addMappings(mapping ->
                mapping.when(Objects::nonNull).using(getLastNameLength).map(Employee::getManager, CustomDto::setManagerLastNameLength)
        );

            all
                .stream()
                .map(employeeToCustom::map)
                .forEach(System.out::println);

    }

    private void persist() {

        Employee manager = new Employee("Manager", "Manager", BigDecimal.ONE, LocalDate.now(), null);

        Employee firstEmployee = new Employee("firstEmployee", "firstEmployee", BigDecimal.TEN, LocalDate.now(), manager);

        this.employeeService.save(firstEmployee);

        manager = this.employeeService.findOneById(firstEmployee.getManager().getId()).get();

        Employee secondEmployee = new Employee("secondEmployee", "secondEmployee", BigDecimal.TEN, LocalDate.now(), manager);

        this.employeeService.save(secondEmployee);
    }
}
