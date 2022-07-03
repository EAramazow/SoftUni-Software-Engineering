package bg.softuni.examprepmay2022.model.dto;

import bg.softuni.examprepmay2022.model.entity.ShipEntity;

public class ShipDTO {

    private Long id;
    private String name;
    private Long health;
    private Long power;

    public ShipDTO(ShipEntity ship) {
        this.id = ship.getId();
        this.name = ship.getName();
        this.power = ship.getPower();
        this.health = ship.getHealth();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getHealth() {
        return health;
    }

    public Long getPower() {
        return power;
    }
}
