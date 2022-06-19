package bg.softuni.exampreparation.service.impl;

import bg.softuni.exampreparation.model.entity.UserEntity;
import bg.softuni.exampreparation.model.service.UserServiceModel;
import bg.softuni.exampreparation.repository.UserRepository;
import bg.softuni.exampreparation.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        // map userServiceModel to UserEntity before save in the database

        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);

        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }
}
