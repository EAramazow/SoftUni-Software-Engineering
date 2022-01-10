package L09UnitTesting.Lab.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(10, 10);
        this.brokenAxe = new Axe(10, 0);
        this.dummy = new Dummy(100, 100);
    }


    @Test
    public void testWeaponLosesDurabilityAfterAttack() {

        // Axe axe = new Axe(10, 10);
        //   Dummy dummy = new Dummy(100, 100);

        axe.attack(dummy);
        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAxeAttackThrowsIfAxeIsBroken() {
        //  Axe brokenAxe = new Axe(10, 0);
        //   Dummy dummy = new Dummy(100, 100);

        brokenAxe.attack(dummy);
    }

}