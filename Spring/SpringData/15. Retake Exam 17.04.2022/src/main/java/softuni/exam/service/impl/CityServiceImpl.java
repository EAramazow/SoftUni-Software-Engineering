package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CityServiceImpl implements CityService {

    private static final String CITIES_FILE_PATH = "src/main/resources/files/json/cities.json";

    private final CityRepository cityRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CountryService countryService;

    public CityServiceImpl(CityRepository cityRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.countryService = countryService;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        CitySeedDto[] cityDtos = gson.fromJson(readCitiesFileContent(), CitySeedDto[].class);

        Arrays
                .stream(cityDtos)
                .filter(citySeedDto -> {
                    boolean isValid = validationUtil.isValid(citySeedDto)
                            && !doesCityExists(citySeedDto.getCityName());

                    stringBuilder.append(isValid
                                    ? String.format("Successfully imported city %s - %d", citySeedDto.getCityName(), citySeedDto.getPopulation())
                                    : "Invalid city")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(citySeedDto -> {
                    City city = modelMapper.map(citySeedDto, City.class);
                    city.setCountry(countryService.findById(citySeedDto.getCountry()));

                    return city;
                })
                .forEach(cityRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public boolean doesEntityExistsById(Long city) {
        return cityRepository.existsById(city);
    }


    private boolean doesCityExists(String cityName) {
        return cityRepository.existsByCityName(cityName);
    }
}
