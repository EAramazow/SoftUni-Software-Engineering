package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastSeedRootDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.enums.DaysOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class ForecastServiceImpl implements ForecastService {

    private static final String FORECASTS_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CityService cityService;
    private final CityRepository cityRepository;

    public ForecastServiceImpl(ForecastRepository forecastRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, CityService cityService, CityRepository cityRepository) {
        this.forecastRepository = forecastRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.cityService = cityService;
        this.cityRepository = cityRepository;
    }


    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECASTS_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        ForecastSeedRootDto forecastSeedRootDto = xmlParser.fromFile(FORECASTS_FILE_PATH, ForecastSeedRootDto.class);

        forecastSeedRootDto
                .getForecasts()
                .stream()
                .filter(forecastSeedDto -> {
                    boolean isValid = validationUtil.isValid(forecastSeedDto)
                            && !doesEntityExistsByDay(forecastSeedDto.getDaysOfWeek())
                            && doesEntityExistsByCityId(forecastSeedDto.getCity())
                            && cityService.doesEntityExistsById(forecastSeedDto.getCity());


                    stringBuilder.append(isValid
                                    ? String.format("Successfully import forecast %s - %.2f", forecastSeedDto.getDaysOfWeek(), forecastSeedDto.getMaxTemperature())
                                    : "Invalid forecast")
                            .append(System.lineSeparator());



//                    boolean isValid = validationUtil.isValid(forecastSeedDto)
//                            && !(isEntityExistByDay(forecastSeedDto.getDaysOfWeek()) && isEntityExistByCityId(forecastSeedDto.getCity()))
//                            && cityService.isEntityExistById(forecastSeedDto.getCity());

//                    sb.append(isValid ? String.format("Successfully imported forecast %s - %.2f",
//                                    forecastSeedDto.getDaysOfWeek(), forecastSeedDto.getMaxTemperature()) : "Invalid forecast")
//                            .append(System.lineSeparator());
//                    return isValid;

                    return isValid;
                })
                .map(forecastSeedDto -> {
                    Forecast forecast = modelMapper.map(forecastSeedDto, Forecast.class);
                    forecast.setCity(cityService.findById(forecast.getCity().getId()));

                    return forecast;
                })
                .forEach(forecastRepository::save);

        // TODO - save forecasts in the database and export forecasts

        return stringBuilder.toString();
    }

    private boolean doesEntityExistsByCityId(Long city) {
        return forecastRepository.existsByCityId(city);
    }

    private boolean doesEntityExistsByDay(DaysOfWeek daysOfWeek) {
        return forecastRepository.existsByDaysOfWeek(daysOfWeek);
    }

    @Override
    public String exportForecasts() {
        return null;
    }
}
