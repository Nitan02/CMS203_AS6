import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTestStudent {

    Coffee coffee;

    @Before
    public void setUp() throws Exception {
        coffee = new Coffee("Latte", Size.MEDIUM, true, false);
    }

    @After
    public void tearDown() throws Exception {
        coffee = null;
    }

    @Test
    public void testGetBasePrice() {
        assertEquals(2.00, coffee.getBasePrice(), 0.01);
    }

    @Test
    public void testGetBevName() {
        assertEquals("Latte", coffee.getBevName());
    }

    @Test
    public void testGetSize() {
        assertEquals(Size.MEDIUM, coffee.getSize());
    }

    @Test
    public void testGetType() {
        assertEquals(Type.COFFEE, coffee.getType());
    }

    @Test
    public void testGetExtraShot() {
        assertTrue(coffee.getExtraShot());
    }

    @Test
    public void testGetExtraSyrup() {
        assertFalse(coffee.getExtraSyrup());
    }


    @Test
    public void testEquals() {
        Coffee coffee1 = new Coffee("Latte", Size.MEDIUM, true, false);
        Coffee coffee2 = new Coffee("Latte", Size.MEDIUM, true, false);
        Coffee coffee3 = new Coffee("Mocha", Size.LARGE, false, true);

        assertTrue(coffee1.equals(coffee2));
        assertFalse(coffee1.equals(coffee3));
    }
}