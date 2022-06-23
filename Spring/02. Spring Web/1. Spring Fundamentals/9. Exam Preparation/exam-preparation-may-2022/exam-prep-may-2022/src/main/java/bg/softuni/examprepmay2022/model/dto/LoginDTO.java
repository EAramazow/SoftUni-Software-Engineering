package bg.softuni.examprepmay2022.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginDTO {

    @Size(min = 3, max = 10)
    @NotBlank
    private String username;
    @Size(min = 3)
    @NotBlank
    private String password;

    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public LoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
