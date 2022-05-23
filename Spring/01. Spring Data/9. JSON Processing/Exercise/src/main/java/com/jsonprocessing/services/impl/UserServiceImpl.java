package com.jsonprocessing.services.impl;

import com.google.gson.Gson;
import com.jsonprocessing.constants.GlobalConstants;
import com.jsonprocessing.models.dto.CategorySeedDto;
import com.jsonprocessing.models.dto.UserSeedDto;
import com.jsonprocessing.models.dto.UserSoldDto;
import com.jsonprocessing.models.entities.Category;
import com.jsonprocessing.models.entities.User;
import com.jsonprocessing.repositories.UserRepository;
import com.jsonprocessing.services.UserService;
import com.jsonprocessing.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.jsonprocessing.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_FILE_NAME = "users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws IOException {

//        String fileContent = Files.readString(Path.of(RESOURCES_FILE_PATH + USERS_FILE_NAME));
//        UserSeedDto[] userSeedDtos = gson.fromJson(fileContent, UserSeedDto[].class);
//
//        Arrays.stream(userSeedDtos)
//                .filter(validationUtil::isValid)
//                        .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
//                                .forEach(userRepository::save);

        if (userRepository.count() == 0) {


            Arrays.stream(gson.fromJson(
                            Files.readString(Path.of(RESOURCES_FILE_PATH + USERS_FILE_NAME)),
                            UserSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                    .forEach(userRepository::save);


        }
    }

    @Override
    public User findRandomUser() {

        long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);

        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts() {
        return userRepository
                .findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenFirstName()
                .stream()
                .map(user -> modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());
    }
}
