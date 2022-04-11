package com.workshoplab.services;

import com.workshoplab.dto.EmployeeDto;
import com.workshoplab.dto.ExportedEmployeesDto;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    String FILE_PATH = "src/main/resources/files/xmls/employees.xml";


    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(EmployeeDto request);

    List<ExportedEmployeesDto> getEmployeesAfter25();
}
