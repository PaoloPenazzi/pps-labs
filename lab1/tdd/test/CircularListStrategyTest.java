import lab01.tdd.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircularListStrategyTest {
    CircularList circularList;

    @BeforeEach
    public void setup() {
        this.circularList = new CircularListImpl();
    }

    @Test
    public void testNextWithStrategy(){
        this.circularList.add(5);
        this.circularList.add(10);
        this.circularList.add(8);
        this.circularList.next();
        Assertions.assertEquals(5, this.circularList.next((element -> element < 7)).get());
    }

    @Test public void testEvenStrategy() {
        this.circularList.add(5);
        this.circularList.add(10);
        Assertions.assertEquals(10, this.circularList.next(new EvenStrategyFactory().createStrategy()).get());
    }

    @Test public void testMultipleOfStrategy() {
        this.circularList.add(5);
        this.circularList.add(10);
        this.circularList.add(8);
        Assertions.assertEquals(8, this.circularList.next(new MultipleOfStrategyFactory(4).createStrategy()).get());
    }

    @Test public void testEqualsStrategy() {
        this.circularList.add(5);
        this.circularList.add(10);
        this.circularList.add(8);
        Assertions.assertEquals(8, this.circularList.next(new EqualsStrategyFactory(8).createStrategy()).get());
    }
}
