package bg.softuni.examprepmay2022.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CreateShipDTO {

    @Size(min = 2, max = 10)
    @NotBlank
    private String name;
    @Positive
    private Long power;
    @Positive
    private Long health;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;
    @Positive
    private int category = -1;

    public CreateShipDTO() {
    }

    public String getName() {
        return name;
    }

    public CreateShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public CreateShipDTO setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public CreateShipDTO setHealth(Long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public CreateShipDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public int getCategory() {
        return category;
    }

    public CreateShipDTO setCategory(int category) {
        this.category = category;
        return this;
    }
}
