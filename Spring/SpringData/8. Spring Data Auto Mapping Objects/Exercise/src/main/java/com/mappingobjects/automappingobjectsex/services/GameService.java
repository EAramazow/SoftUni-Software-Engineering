package com.mappingobjects.automappingobjectsex.services;


import com.mappingobjects.automappingobjectsex.models.dto.GameAddDto;
import com.mappingobjects.automappingobjectsex.models.entities.Game;

import java.math.BigDecimal;
import java.util.Set;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long gameId, BigDecimal price, Double size);

    void deleteGame(Long id);

    void allGames();

    void detailGame(String gameName);

    Set<Game> getAll();
}
