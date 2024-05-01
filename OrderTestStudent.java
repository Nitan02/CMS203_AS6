import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {

    private Order order;
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("John", 30);
        order = new Order(10, Day.MONDAY, customer);
    }

    @Test
    public void testIsWeekend() {
        assertFalse(order.isWeekend());
    }

    @Test
    public void testAddNewBeverageCoffee() {
        order.addNewBeverage("Latte", Size.SMALL, true, false);
        assertEquals(1, order.getTotalItems());
    }

    @Test
    public void testAddNewBeverageAlcohol() {
        order.addNewBeverage("Beer", Size.MEDIUM);
        assertEquals(1, order.getTotalItems());
    }

    @Test
    public void testAddNewBeverageSmoothie() {
        order.addNewBeverage("Berry Blast", Size.LARGE, 3, true);
        assertEquals(1, order.getTotalItems());
    }

    @Test
    public void testCustomer() {
        Customer newCustomer = new Customer("Alice", 25);
        order.Customer(newCustomer);
        assertEquals(newCustomer.getName(), order.getCustomer().getName());
        assertEquals(newCustomer.getAge(), order.getCustomer().getAge());
    }

    @Test
    public void testSetListOfBeverage() {
        ArrayList<Beverage> beverages = new ArrayList<>();
        beverages.add(new Coffee("Latte", Size.SMALL, true, false));
        beverages.add(new Alcohol("Beer", Size.MEDIUM, false));
        order.setListOfBeverage(beverages);
        assertEquals(2, order.getTotalItems());
    }

    @Test
    public void testGetOrderNo() {
        assertTrue(order.getOrderNo() >= 10_000 && order.getOrderNo() <= 90_000);
    }

    @Test
    public void testGetBeverage() {
        Coffee coffee = new Coffee("Latte", Size.SMALL, true, false);
        order.addNewBeverage("Latte", Size.SMALL, true, false);
        assertEquals(coffee.getBevName(), order.getBeverage(0).getBevName());
    }

    @Test
    public void testGetOrderTime() {
        assertEquals(10, order.getOrderTime(), 0.01);
    }

    @Test
    public void testGetOrderDay() {
        assertEquals(Day.MONDAY, order.getOrderDay());
    }
}