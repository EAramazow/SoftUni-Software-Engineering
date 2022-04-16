package com.example.football.service.impl;

import com.example.football.constant.FilesPathConstants;
import com.example.football.models.dto.StatSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public StatServiceImpl(StatRepository statRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.statRepository = statRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(FilesPathConstants.STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        StatSeedRootDto statDtos = xmlParser.fromFile(FilesPathConstants.STATS_FILE_PATH, StatSeedRootDto.class);

        statDtos
                .getStats()
                .stream()
                .filter(statSeedDto -> {
                    boolean isValid = validationUtil.isValid(statSeedDto)
                            && !doesStatExists(statSeedDto.getPassing(), statSeedDto.getShooting(), statSeedDto.getEndurance());

                    stringBuilder
                            .append(isValid
                                    ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                                    statSeedDto.getPassing(), statSeedDto.getShooting(), statSeedDto.getEndurance())
                                    : "Invalid Stat")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(statSeedDto -> modelMapper.map(statSeedDto, Stat.class))
                .forEach(statRepository::save);


        return stringBuilder.toString();
    }

    @Override
    public boolean doesEntityIdExists(Long id) {
        return statRepository.existsById(id);
    }

    @Override
    public Stat findById(Long statId) {
        return statRepository.findById(statId).orElse(null);
    }


    private boolean doesStatExists(Float passing, Float shooting, Float endurance) {
        return statRepository.existsByPassingAndShootingAndEndurance(passing, shooting, endurance);
    }
}
