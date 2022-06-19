package bg.softuni.exampreparation.service;

import bg.softuni.exampreparation.model.entity.UserEntity;
import bg.softuni.exampreparation.model.service.UserServiceModel;
import bg.softuni.exampreparation.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    UserEntity findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
