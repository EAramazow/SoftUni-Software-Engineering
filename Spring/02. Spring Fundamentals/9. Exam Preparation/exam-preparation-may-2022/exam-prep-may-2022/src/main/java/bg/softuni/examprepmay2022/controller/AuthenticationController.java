package bg.softuni.examprepmay2022.controller;

import bg.softuni.examprepmay2022.model.dto.LoginDTO;
import bg.softuni.examprepmay2022.model.dto.UserRegistrationDTO;
import bg.softuni.examprepmay2022.repository.UserRepository;
import bg.softuni.examprepmay2022.service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AuthenticationController(AuthenticationService authenticationService, UserRepository userRepository, ModelMapper modelMapper) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    // register, login, logout

    @ModelAttribute("registrationDTO")
    public UserRegistrationDTO initRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @ModelAttribute("loginDTO")
    public LoginDTO initLoginDTO() {
        return new LoginDTO();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO registrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.authenticationService.register(registrationDTO)) {
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDTO", bindingResult);

            return "redirect:/register";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDTO loginDTO, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/login";
        }

        if (!this.authenticationService.login(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/login";
        }

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        this.authenticationService.logout();

        return "redirect:/";
    }
}
