package bg.softuni.examprepmay2022.controller;

import bg.softuni.examprepmay2022.model.dto.ShipDTO;
import bg.softuni.examprepmay2022.model.dto.StartBattleDTO;
import bg.softuni.examprepmay2022.service.ShipService;
import bg.softuni.examprepmay2022.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;
    private LoggedUser loggedUser;


    @Autowired
    public HomeController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("startBattleDTO")
    public StartBattleDTO initBattleForm() {
        return new StartBattleDTO();
    }


    @GetMapping("/")
    public String loggedOutIndex() {
        return "index";
    }

    @GetMapping("/home")
        public String loggedInIndex(Model model) {
        Long loggedUserId = this.loggedUser.getId();
        List<ShipDTO> ownShips = shipService.getShipsOwnedBy(loggedUserId);
        List<ShipDTO> enemyShips = shipService.getShipsNotOwnedBy(loggedUserId);
        List<ShipDTO> sortedShips = this.shipService.getAllSorted();

        model.addAttribute("ownShips", ownShips);
        model.addAttribute("enemyShips", enemyShips);
        model.addAttribute("sortedShips", sortedShips);

        return "home";
        }
}
