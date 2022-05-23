package com.workshoplab.repositories;

import com.workshoplab.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsAllBy();

    Company findFirstByName(String name);

}
