package com.example.football.service.impl;

import com.example.football.constant.FilesPathConstants;
import com.example.football.models.dto.BestPlayerDto;
import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TeamService teamService;
    private final TownService townService;
    private final StatService statService;

    public PlayerServiceImpl(PlayerRepository playerRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, TeamService teamService, TownService townService, StatService statService) {
        this.playerRepository = playerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.teamService = teamService;
        this.townService = townService;
        this.statService = statService;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(FilesPathConstants.PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        PlayerSeedRootDto playerSeedRootDto = xmlParser.fromFile(FilesPathConstants.PLAYERS_FILE_PATH, PlayerSeedRootDto.class);

        playerSeedRootDto
                .getPlayers()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto)
                            && !doesEmailExists(playerSeedDto.getEmail())
                            && teamService.doesEntityExists(playerSeedDto.getTeam().getName())
                            && townService.doesEntityExists(playerSeedDto.getTown().getName())
                            && statService.doesEntityIdExists(playerSeedDto.getStat().getId());

                    stringBuilder
                            .append(isValid
                                    ? String.format("Successfully imported Player %s %s - %s",
                                    playerSeedDto.getFirstName(),
                                    playerSeedDto.getLastName(),
                                    playerSeedDto.getPosition().name())
                                    : "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);

                    String townName = playerSeedDto.getTown().getName();
                    Town town = townService.findByName(townName);
                    player.setTown(town);

                    String teamName = playerSeedDto.getTeam().getName();
                    Team team = teamService.findByName(teamName);
                    player.setTeam(team);

                    Long statId = playerSeedDto.getStat().getId();
                    Stat stat = statService.findById(statId);
                    player.setStat(stat);

                    return player;
                })
                .forEach(playerRepository::save);

        return stringBuilder.toString();
    }


    @Override
    public String exportBestPlayers() {
        LocalDate after = LocalDate.of(1995, 1, 1);
        LocalDate before = LocalDate.of(2003, 1, 1);



        List<BestPlayerDto> bestPlayerDetails = playerRepository.findBestPlayersBornBetween(after, before);



        return bestPlayerDetails
                .stream()
                .map(BestPlayerDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private boolean doesEmailExists(String email) {
        return playerRepository.existsByEmail(email);
    }
}
