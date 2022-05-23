package L09UnitTesting.Exercise.p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {


    @Test
    public void testBubble() {
        int[] numbersArray = {1, 5, 3, 8, 0, -5};
        int[] expectedNumbersArray = {-5, 0, 1, 3, 5, 8};

        Bubble.sort(numbersArray);
        Assert.assertArrayEquals(expectedNumbersArray, numbersArray);
    }
}
