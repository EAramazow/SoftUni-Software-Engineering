package com.workshoplab.services;

import com.workshoplab.dto.CompanyDto;
import com.workshoplab.entities.Company;

import java.io.IOException;

public interface CompanyService {

     String FILE_PATH = "src/main/resources/files/xmls/companies.xml";

    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(CompanyDto request);

    Company find(Long id);
}
