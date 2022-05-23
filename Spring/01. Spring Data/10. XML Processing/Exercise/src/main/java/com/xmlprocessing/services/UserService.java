package com.xmlprocessing.services;

import com.xmlprocessing.models.dtos.UserSeedDto;
import com.xmlprocessing.models.dtos.UserViewRootDto;
import com.xmlprocessing.models.entities.User;

import java.util.List;

public interface UserService {
    long getCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findUsersWithMoreThanOneSoldProduct();
}
