package bg.softuni.examprepmay2022.controller;

import bg.softuni.examprepmay2022.model.dto.StartBattleDTO;
import bg.softuni.examprepmay2022.service.BattleService;
import bg.softuni.examprepmay2022.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BattleController {

    private final BattleService battleService;
    private ShipService shipService;

    public BattleController(BattleService battleService, ShipService shipService) {
        this.battleService = battleService;
        this.shipService = shipService;
    }

    @PostMapping("/battle")
    public String battle(@Valid StartBattleDTO startBattleDTO, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("startBattleDTO", startBattleDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createShipDTO", bindingResult);

            return "redirect:/home";
        }

        System.out.println(startBattleDTO.getAttackerId() + " " + startBattleDTO.getDefenderId());

        this.battleService.attack(startBattleDTO);

        return "redirect:/home";
    }
}

