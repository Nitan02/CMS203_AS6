import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {

    BevShop bevShop;

    @Before
    public void setUp() throws Exception {
        bevShop = new BevShop();
    }

    @After
    public void tearDown() throws Exception {
        bevShop = null;
    }

    @Test
    public void testValidTime() {
        assertTrue(bevShop.validTime(8));
        assertFalse(bevShop.validTime(5));
        assertFalse(bevShop.validTime(25));
    }
    
    @Test
    public void testProcessSmoothieOrder() {
        // Start a new order
        bevShop.startNewOrder(8, Day.MONDAY, "John", 30);

        // Process a smoothie order
        bevShop.processSmoothieOrder("Berry Blast", Size.SMALL, 3, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
        assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Berry Blast"));
        assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
        assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.SMOOTHIE));
        Smoothie smoothie = (Smoothie) bevShop.getCurrentOrder().getBeverage(0);
        assertEquals(3, smoothie.getNumOfFruits());
        assertTrue(smoothie.getAddProtien());

        // Process another smoothie order
        bevShop.processSmoothieOrder("Tropical Delight", Size.LARGE, 2, false);
        assertEquals(2, bevShop.getCurrentOrder().getTotalItems());
        assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Tropical Delight"));
        assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.LARGE));
        assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.SMOOTHIE));
        smoothie = (Smoothie) bevShop.getCurrentOrder().getBeverage(1);
        assertEquals(2, smoothie.getNumOfFruits());
        assertFalse(smoothie.getAddProtien());
    }
    
    @Test
    public void testFindOrder() {
        // Start a new order
        bevShop.startNewOrder(8, Day.MONDAY, "John", 30);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();

        // Find the order by order number
        assertEquals(0, bevShop.findOrder(orderNo));

        // Start another order
        bevShop.startNewOrder(12, Day.TUESDAY, "Kate", 25);

        // Try to find the order by a non-existing order number
        assertEquals(-1, bevShop.findOrder(orderNo + 1));
    }
    
    @Test
    public void testTotalOrderPrice() {
        // Start a new order
        bevShop.startNewOrder(8, Day.MONDAY, "John", 30);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();

        // Process some beverages for the order
        bevShop.processAlcoholOrder("Mohito", Size.SMALL);
        bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
        bevShop.processSmoothieOrder("Detox", Size.MEDIUM, 3, true);

        // Calculate the total order price
        double expectedTotal = 0;
        for (int i = 0; i < bevShop.getCurrentOrder().getTotalItems(); i++) {
            expectedTotal += bevShop.getCurrentOrder().getBeverage(i).calcPrice();
        }

        // Check if the calculated total matches the one returned by totalOrderPrice method
        assertEquals(expectedTotal, bevShop.totalOrderPrice(orderNo), 0.01);
    }
    
    @Test
    public void testTotalMonthlySale() {
        // Start multiple orders with different beverages
        bevShop.startNewOrder(8, Day.MONDAY, "John", 30);
        bevShop.processAlcoholOrder("Mohito", Size.SMALL);
        bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);

        bevShop.startNewOrder(8, Day.SUNDAY, "Jane", 25);
        bevShop.processSmoothieOrder("Detox", Size.MEDIUM, 3, true);
        bevShop.processCoffeeOrder("Latte", Size.LARGE, false, true);

        // Calculate the expected total monthly sale
        double expectedTotal = 0;
        for (Order order : bevShop.orders) {
            expectedTotal += order.calcOrderTotal();
        }

        // Check if the calculated total matches the one returned by totalMonthlySale method
        assertEquals(expectedTotal, bevShop.totalMonthlySale(), 0.01);
    }
    
    @Test
    public void testGetOrderAtIndex() {
        // Start a new order and add some beverages
        bevShop.startNewOrder(8, Day.MONDAY, "John", 30);
        bevShop.processAlcoholOrder("Mohito", Size.SMALL);
        bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);

        // Get the order at index 0
        Order orderAtIndex0 = bevShop.getOrderAtIndex(0);

        // Check if the returned order matches the one at index 0 in the orders list
        assertEquals(bevShop.orders.get(0), orderAtIndex0);
    }
    
    @Test
    public void testProcessAlcoholOrder() {
        // Start a new order
        bevShop.startNewOrder(8, Day.MONDAY, "John", 30);

        // Process an alcohol order
        bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
        assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Vodka"));
        assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.MEDIUM));
        assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.ALCOHOL));

        // Process another alcohol order
        bevShop.processAlcoholOrder("Whiskey", Size.SMALL);
        assertEquals(2, bevShop.getCurrentOrder().getTotalItems());
        assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Whiskey"));
        assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.SMALL));
        assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.ALCOHOL));
    }

    @Test
    public void testValidAge() {
        assertTrue(bevShop.validAge(25));
        assertFalse(bevShop.validAge(18));
    }
    
    @Test
    public void testProcessCoffeeOrder() {
        // Start a new order
        bevShop.startNewOrder(8, Day.MONDAY, "John", 30);

        // Process a coffee order with extra shot and extra syrup
        bevShop.processCoffeeOrder("Latte", Size.SMALL, true, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
        assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Latte"));
        assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
        assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.COFFEE));
        assertTrue(((Coffee) bevShop.getCurrentOrder().getBeverage(0)).getExtraShot());
        assertTrue(((Coffee) bevShop.getCurrentOrder().getBeverage(0)).getExtraSyrup());

        // Process another coffee order without extra shot and extra syrup
        bevShop.processCoffeeOrder("Americano", Size.LARGE, false, false);
        assertEquals(2, bevShop.getCurrentOrder().getTotalItems());
        assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Americano"));
        assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.LARGE));
        assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.COFFEE));
        assertFalse(((Coffee) bevShop.getCurrentOrder().getBeverage(1)).getExtraShot());
        assertFalse(((Coffee) bevShop.getCurrentOrder().getBeverage(1)).getExtraSyrup());
    }

    @Test
    public void testStartNewOrder() {
        bevShop.startNewOrder(8, Day.MONDAY, "John", 30);
        assertEquals(1, bevShop.totalNumOfMonthlyOrders());
    }

    // Similarly, write tests for other methods...
}