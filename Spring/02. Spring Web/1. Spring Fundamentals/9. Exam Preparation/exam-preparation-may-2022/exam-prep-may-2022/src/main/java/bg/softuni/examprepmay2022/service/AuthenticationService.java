package bg.softuni.examprepmay2022.service;

import bg.softuni.examprepmay2022.model.dto.LoginDTO;
import bg.softuni.examprepmay2022.model.dto.UserRegistrationDTO;
import bg.softuni.examprepmay2022.model.entity.UserEntity;
import bg.softuni.examprepmay2022.repository.UserRepository;
import bg.softuni.examprepmay2022.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final LoggedUser userSession;

    @Autowired
    public AuthenticationService(UserRepository userRepository, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

        public boolean register (UserRegistrationDTO registrationDTO){
            if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
                return false;
            }

            Optional<UserEntity> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
            if (byEmail.isPresent()) {
                return false;
            }

            Optional<UserEntity> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());
            if (byUsername.isPresent()) {
                return false;
            }

            UserEntity user = new UserEntity();
            user.setUsername(registrationDTO.getUsername());
            user.setEmail(registrationDTO.getEmail());
            user.setFullName(registrationDTO.getFullName());
            user.setPassword(registrationDTO.getPassword());

            this.userRepository.save(user);

            return true;
        }

    public boolean login(LoginDTO loginDTO) {
        Optional<UserEntity> user = this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (user.isEmpty()) {
            return false;
        }

        // actual login

        this.userSession.login(user.get());

        return true;
    }

    public void logout() {
        this.userSession.logout();
    }
}


