package L09UnitTesting.Exercise.p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static junit.framework.TestCase.assertEquals;

public class DatabaseTest {
    private Database database;

    private static final Person[] EXPECTED_PERSONS = {
            new Person(1, "firstPerson"),
            new Person(2, "secondPerson"),
            new Person(3, "thirdPerson"),
            new Person(4, "fourthPerson"),
    };

    @Before
    public void setUp() throws OperationNotSupportedException {
        Person firstPerson = new Person(1, "firstPerson");
        Person secondPerson = new Person(2, "secondPerson");
        Person thirdPerson = new Person(3, "thirdPerson");
        Person fourthPerson = new Person(4, "fourthPerson");
        database = new Database(firstPerson, secondPerson, thirdPerson, fourthPerson);
    }


    @Test
    public void testDatabaseConstructorShouldCreateValidState() {
        Person[] elements = database.getElements();
        assertEquals(EXPECTED_PERSONS.length, elements.length);

        for (int i = 0; i < EXPECTED_PERSONS.length; i++) {
            assertEquals(EXPECTED_PERSONS[i], elements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorShouldThrowExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        Person[] numbers = new Person[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorShouldThrowExceptionForLessThanOneElement() throws OperationNotSupportedException {
        Person[] numbers = new Person[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodShouldThrowExceptionIfParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddMethodShouldAddAtFirstEmptyIndex() throws OperationNotSupportedException {
        Person fifthPerson = new Person(5, "fifthPerson");
        database.add(fifthPerson);
        Person[] elements = database.getElements();
        assertEquals(5, elements.length);

    }


    @Test
    public void testRemoveMethodShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Person[] actualPersons = database.getElements();
        Person[] expected = {
                new Person(1, "firstPerson"),
                new Person(2, "secondPerson"),
                new Person(3, "thirdPerson")
        };
        assertEquals(expected.length, actualPersons.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodShouldThrowExceptionIfDatabaseIsEmpty() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindUserByUsernameShouldThrowExceptionIfParameterIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowExceptionIfUserDoesNotExist() throws OperationNotSupportedException {
        database.findByUsername("Username does not exist");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowExceptionIfUsernameAlreadyExist() throws OperationNotSupportedException {
        Person firstPerson = new Person(1, "firstPerson");
        Person secondPerson = new Person(2, "secondPerson");
        Person thirdPerson = new Person(3, "thirdPerson");
        Person fourthPerson = new Person(3, "thirdPerson");

        Database database = new Database(firstPerson, secondPerson, thirdPerson, fourthPerson);

        database.findByUsername("thirdPerson");
    }

    @Test
    public void testFindByUsernameShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person person = this.database.findByUsername("firstPerson");
        assertEquals(new Person(1, "firstPerson"), person);
    }

    @Test
    public void testFindByIdShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person findById = database.findById(1);
        assertEquals(1, findById.getId());
        assertEquals("firstPerson", findById.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowExceptionIfIdDoesNotExist() throws OperationNotSupportedException {
        database.findById(12321);
    }

}
