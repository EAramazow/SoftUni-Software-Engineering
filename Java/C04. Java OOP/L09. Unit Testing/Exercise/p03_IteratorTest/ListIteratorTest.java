package L09UnitTesting.Exercise.p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private static final String[] NAMES = new String[] {"Evgenia", "Teodor", "Danail", "Angel"};
    ListIterator listIterator;


    @Before
    public void prepare() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowException() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructorShouldCreateListIterator() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(NAMES);

    }

    @Test
    public void testHasNext() {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void move() {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());

    }

    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowExceptionForEmptyList() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintSuccess(){
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(NAMES[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }


}
