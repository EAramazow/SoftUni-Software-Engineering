package com.mappingobjects.automappingobjectsex.repositories;

import com.mappingobjects.automappingobjectsex.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findByTitle(String gameName);


    Set<Game> findAllBy();
}
