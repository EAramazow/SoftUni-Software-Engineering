package com.workshoplab.services;

import com.workshoplab.dto.ExportedProjectDto;
import com.workshoplab.dto.ProjectDto;
import com.workshoplab.entities.Project;

import java.io.IOException;
import java.util.List;

public interface ProjectService {

    String FILE_PATH = "src/main/resources/files/xmls/projects.xml";


    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(ProjectDto request);

    Project find(Long id);

    List<ExportedProjectDto> finishedProjects();
}
