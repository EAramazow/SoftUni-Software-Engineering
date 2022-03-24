package com.jsonprocessing.services;

import com.jsonprocessing.models.dto.UserSoldDto;
import com.jsonprocessing.models.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void seedUsers() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts();

}
