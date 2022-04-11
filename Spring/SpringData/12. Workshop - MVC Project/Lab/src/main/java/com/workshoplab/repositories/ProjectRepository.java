package com.workshoplab.repositories;

import com.workshoplab.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsAllBy();

    Project findFirstByNameAndCompanyName(String name, String companyName);

    List<Project> findAllByFinishedIsTrue();
}
