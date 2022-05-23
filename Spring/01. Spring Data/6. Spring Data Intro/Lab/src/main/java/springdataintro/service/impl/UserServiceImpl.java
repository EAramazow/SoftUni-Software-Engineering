package springdataintro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintro.dataAccessObject.UserRepository;
import springdataintro.entity.User;
import springdataintro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User register(User user) {
        return userRepo.save(user);
    }
}
