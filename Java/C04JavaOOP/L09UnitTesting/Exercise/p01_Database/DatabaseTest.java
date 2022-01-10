package L09UnitTesting.Exercise.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {1, 2, 3, 4};
    private static final int TOO_BIG_NUMBER = 17;

    private Database database;

    // Test the constructor
    // 1. Constructor creates Database instance (happy path)
    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    // 2. If constructor take more than 16 elements -> OperationNotSupportedException.class
    @Test
    public void testConstructorShouldCreateValidDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
        Integer[] dbElements = database.getElements();

        Assert.assertEquals("Count of db elements is incorrect", dbElements.length, NUMBERS.length);

        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals("We have different elements in the DB", dbElements[i], NUMBERS[i]);
        }

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] largeArray = new Integer[TOO_BIG_NUMBER];
        new Database(largeArray);
    }

    // 3. If constructor have less than one element -> OperationNotSupportedException

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionForLessThanOneElements() throws OperationNotSupportedException {
        Integer[] smallArray = new Integer[0];
        new Database(smallArray);
    }

    // 4. Add method with null argument -> OperationNotSupportedException

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowsExceptionWithNullArgument() throws OperationNotSupportedException {
        database.add(null);
    }


    // 5. Add method works fine (Happy path)

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(6);
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(dbElements.length, NUMBERS.length + 1);
        Assert.assertEquals(dbElements[dbElements.length - 1], Integer.valueOf(6));
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodShouldThrowsOperationNotSupportedException() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveMethodShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] dbElements = database.getElements();

        Assert.assertEquals(NUMBERS.length - 1, dbElements.length);
        Assert.assertEquals(Integer.valueOf(NUMBERS.length - 1), dbElements[dbElements.length - 1]);
    }

}
