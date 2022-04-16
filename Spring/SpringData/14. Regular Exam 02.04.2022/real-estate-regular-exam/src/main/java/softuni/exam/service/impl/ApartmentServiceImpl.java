package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentSeedRootDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private static final String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    private final ApartmentRepository apartmentRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, XmlParser xmlParser, ValidationUtil validationUtil, TownRepository townRepository, ModelMapper modelMapper) {
        this.apartmentRepository = apartmentRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser
                .fromFile(APARTMENTS_FILE_PATH, ApartmentSeedRootDto.class)
                .getApartments()
                .stream()
                .filter(apartmentSeedDto -> {
                    boolean isValid = validationUtil.isValid(apartmentSeedDto) &&
                            !apartmentRepository.existsByTownTownName(apartmentSeedDto.getTown()) &&
                                    !apartmentRepository.existsByArea(apartmentSeedDto.getArea());

                    stringBuilder
                            .append(isValid
                                    ? String.format("Successfully imported apartment %s - %.2f",
                                    apartmentSeedDto.getApartmentType().name(),
                                    apartmentSeedDto.getArea()) :
                                    "Invalid apartment")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(apartmentSeedDto -> {
                    Apartment apartment = modelMapper.map(apartmentSeedDto, Apartment.class);

                    apartment.setTown(townRepository.findByTownName(apartmentSeedDto.getTown()));

                    return apartment;
                })
                .forEach(apartmentRepository::save);

        return stringBuilder.toString();
    }
}
