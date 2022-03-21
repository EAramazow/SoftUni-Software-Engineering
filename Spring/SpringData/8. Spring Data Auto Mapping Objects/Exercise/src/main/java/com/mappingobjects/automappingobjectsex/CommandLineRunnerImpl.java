package com.mappingobjects.automappingobjectsex;

import com.mappingobjects.automappingobjectsex.models.dto.GameAddDto;
import com.mappingobjects.automappingobjectsex.models.dto.UserLoginDto;
import com.mappingobjects.automappingobjectsex.models.dto.UserRegisterDto;
import com.mappingobjects.automappingobjectsex.services.GameService;
import com.mappingobjects.automappingobjectsex.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {


        while (true) {
            System.out.println("Enter your commands: ");
            String[] commands = bufferedReader.readLine().split("\\|");

            switch (commands[0]) {
                case "RegisterUser":
                    userService.registerUser(new UserRegisterDto(commands[1], commands[2], commands[3], commands[4]));
                    break;

                case "LoginUser":
                    userService.loginUser(new UserLoginDto(commands[1], commands[2]));
                    break;

                case "Logout":
                    userService.logout();
                    break;

                case "AddGame":
                    gameService.addGame(new GameAddDto(commands[1], new BigDecimal(commands[2]), Double.parseDouble(commands[3]), commands[4], commands[5], commands[6], commands[7]));
                    break;

                case "EditGame":
                    gameService.editGame(Long.parseLong(commands[1]), new BigDecimal(commands[2]), Double.parseDouble(commands[3]));
                    break;

                case "DeleteGame":
                    gameService.deleteGame(Long.parseLong(commands[1]));
                    break;

                case "AllGames":
                    gameService.allGames();
                    break;

                case "DetailGame":
                    gameService.detailGame(commands[1]);
                    break;

                case "OwnedGames":
                    ownedGames();
                    break;

            }
        }

    }

    private void ownedGames() {
        if (this.userService.getCurrentUser() == null) {
            System.out.println("There is no logged user");
        } else {
            getAllOwnedItems();
        }
    }

    private void getAllOwnedItems() {
        this.userService.getCurrentUser().setGames(this.gameService.getAll());
    }

}
