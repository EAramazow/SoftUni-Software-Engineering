package com.mappingobjects.automappingobjectsex.services;

import com.mappingobjects.automappingobjectsex.models.dto.UserLoginDto;
import com.mappingobjects.automappingobjectsex.models.dto.UserRegisterDto;
import com.mappingobjects.automappingobjectsex.models.entities.User;

public interface UserService{
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    User getCurrentUser();
}
