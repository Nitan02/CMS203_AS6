import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SizeTestStudent {

    @Test
    public void testSmall() {
        assertEquals("SMALL", Size.SMALL.toString());
    }

    @Test
    public void testMedium() {
        assertEquals("MEDIUM", Size.MEDIUM.toString());
    }

    @Test
    public void testLarge() {
        assertEquals("LARGE", Size.LARGE.toString());
    }
}