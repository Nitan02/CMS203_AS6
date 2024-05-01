import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayTestStudent {

    @Test
    public void testMonday() {
        assertEquals("MONDAY", Day.MONDAY.toString());
    }

    @Test
    public void testTuesday() {
        assertEquals("TUESDAY", Day.TUESDAY.toString());
    }

    @Test
    public void testWednesday() {
        assertEquals("WEDNESDAY", Day.WEDNESDAY.toString());
    }

    @Test
    public void testThursday() {
        assertEquals("THURSDAY", Day.THURSDAY.toString());
    }

    @Test
    public void testFriday() {
        assertEquals("FRIDAY", Day.FRIDAY.toString());
    }

    @Test
    public void testSaturday() {
        assertEquals("SATURDAY", Day.SATURDAY.toString());
    }

    @Test
    public void testSunday() {
        assertEquals("SUNDAY", Day.SUNDAY.toString());
    }
}