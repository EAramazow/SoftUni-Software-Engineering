package com.example.football.service.impl;

import com.example.football.constant.FilesPathConstants;
import com.example.football.models.dto.TownSeedDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(FilesPathConstants.TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        TownSeedDto[] townDtos = gson.fromJson(readTownsFileContent(), TownSeedDto[].class);

        Arrays
                .stream(townDtos)
                .filter(townSeedDto -> {
                    boolean isValid = validationUtil.isValid(townSeedDto)
                            && !doesEntityExists(townSeedDto.getName());

                    stringBuilder
                            .append(isValid
                                    ? String.format("Successfully imported Town %s - %d", townSeedDto.getName(), townSeedDto.getPopulation())
                                    : "Invalid Town")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(townSeedDto -> modelMapper.map(townSeedDto, Town.class))
                .forEach(townRepository::save);

        return stringBuilder.toString();
    }

    public boolean doesEntityExists(String name) {
        return townRepository.existsByName(name);
    }

    @Override
    public Town findByName(String townName) {
        return townRepository.findByName(townName).orElse(null);
    }
}
