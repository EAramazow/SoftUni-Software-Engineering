package com.workshoplab.services;

import com.workshoplab.dto.UserLoginDto;
import com.workshoplab.entities.dtos.UserRegisterDto;

public interface UserService {

    boolean register(UserRegisterDto user);

    Long validateUserLoginDetails(UserLoginDto user);

    String getXmlForImport();
}
