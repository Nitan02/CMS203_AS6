import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TypeTestStudent {

    @Test
    public void testCoffee() {
        assertEquals("COFFEE", Type.COFFEE.toString());
    }

    @Test
    public void testSmoothie() {
        assertEquals("SMOOTHIE", Type.SMOOTHIE.toString());
    }

    @Test
    public void testAlcohol() {
        assertEquals("ALCOHOL", Type.ALCOHOL.toString());
    }
}