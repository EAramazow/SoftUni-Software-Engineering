package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.PictureSeedDto;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {

    private final static String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }


    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readFromFileContent(), PictureSeedDto[].class))
                .filter(pictureSeedDto -> {
                    boolean isValid = validationUtil.isValid(pictureSeedDto) && !isEntityExists(pictureSeedDto.getPath());
                    stringBuilder
                            .append(isValid
                                    ? String.format("Successfully imported Picture, with size %.2f", pictureSeedDto.getSize())
                                    : "Invalid picture")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(pictureSeedDto -> modelMapper.map(pictureSeedDto, Picture.class))
                .forEach(pictureRepository::save);


        return stringBuilder.toString();
    }

    @Override
    public boolean isEntityExists(String path) {
        return pictureRepository.existsByPath(path);
    }

    @Override
    public String exportPictures() {
        StringBuilder stringBuilder = new StringBuilder();
        pictureRepository
                .findAllBySizeGreaterThanOrderBySize(30000D)
                .forEach(picture -> {
                    stringBuilder.append(String.format("%.2f - %s", picture.getSize(), picture.getPath()))
                            .append(System.lineSeparator());
                });

        return stringBuilder.toString();
    }

    @Override
    public Picture findByPath(String path) {
        return pictureRepository.findByPath(path).orElse(null);
    }

}
