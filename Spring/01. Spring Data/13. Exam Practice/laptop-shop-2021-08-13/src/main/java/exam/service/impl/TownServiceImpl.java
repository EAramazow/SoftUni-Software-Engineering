package exam.service.impl;

import exam.model.dtos.TownSeedRootDto;
import exam.model.entities.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWN_FILE_PATH = "src/main/resources/files/xml/towns.xml";

    private final TownRepository townRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {

        TownSeedRootDto townSeedRootDto = xmlParser.fromFile(TOWN_FILE_PATH, TownSeedRootDto.class);

        StringBuilder stringBuilder = new StringBuilder();

        townSeedRootDto
                .getTowns()
                .stream()
                .filter(townSeedDto -> {
                    boolean isValid = validationUtil.isValid(townSeedDto);


                    stringBuilder
                            .append(isValid
                                    ? String.format("Successfully imported Town %s", townSeedDto.getName())
                                    : "Invalid Town")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(townSeedDto -> this.modelMapper.map(townSeedDto, Town.class))
                .forEach(townRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public boolean doesEntityExists(String name) {
        return townRepository.existsByName(name);
    }

    @Override
    public Town findByName(String name) {
        return townRepository.findByName(name);
    }
}
