package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountrySeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String COUNTRIES_PATH_FILE = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_PATH_FILE));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        CountrySeedDto[] countryDtos = gson.fromJson(readCountriesFromFile(), CountrySeedDto[].class);

        Arrays
                .stream(countryDtos)
                .filter(countrySeedDto -> {
                    boolean isValid = validationUtil.isValid(countrySeedDto)
                            && !doesCountryExists(countrySeedDto.getCountryName());

                    stringBuilder.append(isValid
                                    ? String.format("Successfully imported country %s - %s", countrySeedDto.getCountryName(), countrySeedDto.getCurrency())
                                    : "Invalid country")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(countrySeedDto -> modelMapper.map(countrySeedDto, Country.class))
                .forEach(countryRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }


    private boolean doesCountryExists(String countryName) {
        return countryRepository.existsByCountryName(countryName);
    }
}
