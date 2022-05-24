package L09UnitTesting.Lab.rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int HEALTH = 100;
    private static final int XP = 50;

    private Dummy dummy;
    private Dummy deathDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(HEALTH, XP);
        this.deathDummy = new Dummy(0, XP);
    }


    @Test
    public void testDummyLosesHealthWhenAttacked() {
        int attackPoints = 10;
        dummy.takeAttack(attackPoints);
        assertEquals(HEALTH - attackPoints, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsWhenAttacked() {
        int attackPoints = 10;
        deathDummy.takeAttack(attackPoints);

    }

    @Test
    public void testDeadDummyGivesXP() {
        int actual = deathDummy.giveExperience();
        assertEquals(XP, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyThrowsWhenGivingXP() {
        dummy.giveExperience();
    }
}
