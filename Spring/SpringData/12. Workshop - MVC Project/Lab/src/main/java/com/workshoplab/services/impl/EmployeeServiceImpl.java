package com.workshoplab.services.impl;

import com.workshoplab.dto.EmployeeDto;
import com.workshoplab.dto.ExportedEmployeesDto;
import com.workshoplab.entities.Employee;
import com.workshoplab.repositories.EmployeeRepository;
import com.workshoplab.services.EmployeeService;
import com.workshoplab.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectService projectService;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ProjectService projectService, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.projectService = projectService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean exists() {
        return this.employeeRepository.existsAllBy();
    }

    @Override
    public String getXmlForImport() throws IOException {
        return new String(this.getClass().getClassLoader().getResourceAsStream(FILE_PATH).readAllBytes(), StandardCharsets.UTF_8);
    }

    @Override
    public Long create(EmployeeDto request) {
        var existing = this.employeeRepository.findFirstByFirstNameAndLastNameAndAge(
                request.getFirstName(), request.getLastName(), request.getAge()
        );

        if (existing != null) {
            return existing.getId();
        }

        var employee = this.modelMapper.map(request, Employee.class);
        var projectId = this.projectService.create(request.getProject());
        var project = this.projectService.find(projectId);

        employee.setProject(project);

        this.employeeRepository.save(employee);

        return employee.getId();
    }

    @Override
    public List<ExportedEmployeesDto> getEmployeesAfter25() {
        return this.employeeRepository.findAllByAgeAfter(25)
                .stream()
                .map(e -> modelMapper.map(e, ExportedEmployeesDto.class))
                .collect(Collectors.toList());
    }
}
