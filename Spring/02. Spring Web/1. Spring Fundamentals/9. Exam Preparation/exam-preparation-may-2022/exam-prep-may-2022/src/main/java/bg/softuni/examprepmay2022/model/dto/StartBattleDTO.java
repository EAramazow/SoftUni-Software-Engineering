package bg.softuni.examprepmay2022.model.dto;

import javax.validation.constraints.Positive;

public class StartBattleDTO {

    @Positive
    private int attackerId;
    @Positive
    private int defenderId;

    public int getAttackerId() {
        return attackerId;
    }

    public StartBattleDTO setAttackerId(int attackerId) {
        this.attackerId = attackerId;
        return this;
    }

    public int getDefenderId() {
        return defenderId;
    }

    public StartBattleDTO setDefenderId(int defenderId) {
        this.defenderId = defenderId;
        return this;
    }
}
