package com.mappingobjects.automappingobjectsex.services.impl;

import com.mappingobjects.automappingobjectsex.models.dto.GameAddDto;
import com.mappingobjects.automappingobjectsex.models.dto.GameViewDto;
import com.mappingobjects.automappingobjectsex.models.entities.Game;
import com.mappingobjects.automappingobjectsex.repositories.GameRepository;
import com.mappingobjects.automappingobjectsex.services.GameService;
import com.mappingobjects.automappingobjectsex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);

        game.setReleaseDate(LocalDate.parse(gameAddDto.getReleaseDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        gameRepository.save(game);

        System.out.println("Added game " + gameAddDto.getTitle());
    }

    @Override
    public void editGame(Long gameId, BigDecimal price, Double size) {
        Game game = gameRepository
                .findById(gameId).orElse(null);

        if (game == null) {
            System.out.println("Id is not correct");
            return;
        }

        game.setPrice(price);
        game.setSize(size);

        gameRepository.save(game);
    }

    @Override
    @Transactional
    public void deleteGame(Long id) {

        Game game = gameRepository.findById(id).orElse(null);

        if (game == null) {
            System.out.println("Game does not exist");
        }

        gameRepository.deleteById(id);

        System.out.println("Deleted " + game.getTitle());


    }

    @Override
    public void allGames() {
        this.gameRepository
                .findAll()
                .stream()
                .map(game -> modelMapper.map(game, GameViewDto.class))
                .map(GameViewDto::toString)
                .forEach(System.out::println);
    }

    @Override
    public void detailGame(String title) {
        Game game = gameRepository.findByTitle(title).orElse(null);

        if (game == null) {
            System.out.println("Game with this title does not exist");
        }

        gameRepository
                .findByTitle(title)
                .stream()
                .map(detail -> modelMapper.map(detail, GameViewDto.class))
                .map(GameViewDto::toString)
                .forEach(System.out::println);
    }

    @Override
    public Set<Game> getAll() {
        return this.gameRepository.findAllBy();
    }


}
