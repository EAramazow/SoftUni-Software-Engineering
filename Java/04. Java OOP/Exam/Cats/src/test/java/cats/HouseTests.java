package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {
    private Cat firstCat;
    private Cat secondCat;
    private House house;

    @Before
    public void setUp () {
        firstCat = new Cat("Tommy");
        secondCat = new Cat("Bamby");
        house = new House("LongHouse", 2);
    }


    @Test (expected = NullPointerException.class)
    public void testNameShouldThrowExceptionIfNameIsNull(){
        House house = new House(null, 2);
    }

    @Test (expected = NullPointerException.class)
    public void testNameShouldTrowExceptionIfNameIsEmpty(){
        House house = new House("       ", 2);
    }

    @Test
    public void testHouseNameIsCorrect(){
        assertEquals("LongHouse", house.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCapacityShouldThrowExceptionIfCapacityIsFull(){
        house.addCat(firstCat);
        house.addCat(secondCat);
        house.addCat(new Cat("Johnny"));

    }

    @Test
    public void testCapacityIfIsNotFull(){

       int expected = house.getCapacity();
       House newHouse = new House("NewHouse", 2);
       int actual = newHouse.getCapacity();
       assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityShouldThrowExceptionIfCapacityIsLessThanZero(){
        int expected = house.getCapacity();
        House newHouse = new House("NewHouse", -2);
        int actual = newHouse.getCapacity();
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveMethodShouldThrowExceptionIfCatToRemoveIsNull(){
        house.removeCat(null);
    }

    @Test
    public void testRemoveMethodShouldRemoveCatCorrectly(){
        house.addCat(firstCat);
        house.removeCat("Tommy");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMethodShouldThrowExceptionBecauseOfNonExistingName(){
        house.addCat(firstCat);
        house.removeCat("Tommy");
        house.removeCat("Emil");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleShouldThrowException(){
        house.addCat(firstCat);
        house.catForSale("Tom");
    }

    @Test
    public void testCatForSaleShouldWorkCorrectly(){
        house.addCat(firstCat);
        house.catForSale(firstCat.getName());
    }

    @Test
    public void testCatForSaleIsHungry(){
        House house = new House("NewHouse", 2);
        Cat cat = new Cat("Tom");
        house.addCat(cat);

        house.catForSale("Tom");
        assertFalse(cat.isHungry());

    }

    @Test
    public void testStatisticsMethodShouldWorkCorrectly(){
        house.addCat(firstCat);

        String expected = String.format("The cat %s is in the house %s!", firstCat.getName(), house.getName());
        String output = house.statistics();

        assertEquals(expected, output);
    }


}
