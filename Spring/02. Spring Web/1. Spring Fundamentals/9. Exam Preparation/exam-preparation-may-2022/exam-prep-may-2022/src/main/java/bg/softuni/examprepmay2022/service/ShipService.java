package bg.softuni.examprepmay2022.service;

import bg.softuni.examprepmay2022.model.dto.CreateShipDTO;
import bg.softuni.examprepmay2022.model.dto.ShipDTO;
import bg.softuni.examprepmay2022.model.entity.CategoryEntity;
import bg.softuni.examprepmay2022.model.entity.ShipEntity;
import bg.softuni.examprepmay2022.model.entity.UserEntity;
import bg.softuni.examprepmay2022.model.entity.enums.ShipTypeEnum;
import bg.softuni.examprepmay2022.repository.CategoryRepository;
import bg.softuni.examprepmay2022.repository.ShipRepository;
import bg.softuni.examprepmay2022.repository.UserRepository;
import bg.softuni.examprepmay2022.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipService {

    private ShipRepository shipRepository;
    private CategoryRepository categoryRepository;
    private LoggedUser loggedUser;
    private UserRepository userRepository;

    public ShipService(ShipRepository shipRepository,
                       CategoryRepository categoryRepository,
                       LoggedUser loggedUser,
                       UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean create(CreateShipDTO createShipDTO) {

        Optional<ShipEntity> byName =
                this.shipRepository.findByName(createShipDTO.getName());

        if (byName.isPresent()) {
            return false;
        }

        ShipTypeEnum type = switch (createShipDTO.getCategory()) {
            case 0 -> ShipTypeEnum.BATTLE;
            case 1 -> ShipTypeEnum.CARGO;
            case 2 -> ShipTypeEnum.PATROL;
            default -> ShipTypeEnum.BATTLE;
        };

        CategoryEntity category = this.categoryRepository.findByName(type);
        Optional<UserEntity> owner = this.userRepository.findById(this.loggedUser.getId());

        ShipEntity ship = new ShipEntity();
        ship.setName(createShipDTO.getName());
        ship.setPower(createShipDTO.getPower());
        ship.setHealth(createShipDTO.getHealth());
        ship.setCreated(createShipDTO.getCreated());
        ship.setCategory(category);
        ship.setUser(owner.get());

        this.shipRepository.save(ship);

        return true;
    }


    public List<ShipDTO> getShipsOwnedBy(Long ownerId) {
        return this.shipRepository.findByUserId(ownerId)
                .stream()
                .map(ShipDTO::new).collect(Collectors.toList());
    }

    public List<ShipDTO> getShipsNotOwnedBy(Long ownerId) {
        return this.shipRepository.findByUserIdNot(ownerId)
                .stream()
                .map(ShipDTO::new).collect(Collectors.toList());
    }

    public List<ShipDTO> getAllSorted() {
        return this.shipRepository.findByOrderByHealthAscNameDescPowerAsc()
                .stream()
                .map(ShipDTO::new).collect(Collectors.toList());    }
}