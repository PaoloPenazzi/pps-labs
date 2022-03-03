import lab01.tdd.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private final int firstNumber = 5;
    private final int secondNumber = 10;
    private final int thirdNumber = 8;
    CircularList circularList;

    @BeforeEach
    public void setup() {
        this.circularList = new CircularListImpl();
    }

    @Test public void testSize() {
        Assertions.assertEquals(0, this.circularList.size());
    }

    @Test public void testAddElement() {
        this.circularList.add(firstNumber);
        Assertions.assertEquals(1, this.circularList.size());
    }

    @Test public void testIsEmpty() {
        Assertions.assertTrue(this.circularList.isEmpty());
    }

    @Test public void testNext() {
        this.circularList.add(firstNumber);
        Assertions.assertEquals(firstNumber, this.circularList.next().get());
    }

    @Test public void testNextFail() {
        Assertions.assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test public void testNextCircular() {
        this.circularList.add(firstNumber);
        this.circularList.add(secondNumber);
        this.circularList.next();
        this.circularList.next();
        Assertions.assertEquals(firstNumber, this.circularList.next().get());
    }

    @Test public void testPrevious() {
        this.circularList.add(firstNumber);
        this.circularList.add(secondNumber);
        Assertions.assertEquals(firstNumber, this.circularList.previous().get());
    }

    @Test public void testPreviousFail() {
        Assertions.assertEquals(Optional.empty(), this.circularList.previous());
    }

    @Test public void testReset() {
        this.circularList.add(firstNumber);
        this.circularList.add(secondNumber);
        this.circularList.add(thirdNumber);
        this.circularList.next();
        this.circularList.reset();
        Assertions.assertEquals(firstNumber, this.circularList.next().get());
    }
}
