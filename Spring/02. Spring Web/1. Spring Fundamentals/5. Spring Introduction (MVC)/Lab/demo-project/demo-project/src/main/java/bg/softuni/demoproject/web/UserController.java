package bg.softuni.demoproject.web;

import bg.softuni.demoproject.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String newUser() {
        return "newuser";
    }

    @PostMapping
    public String createUser(UserDTO userDTO) {
        System.out.println("Creating new user... " + userDTO);
        return "usercreated";
    }
}