import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerTestStudent {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("John", 30);
    }

    @Test
    public void testGetName() {
        assertEquals("John", customer.getName());
    }

    @Test
    public void testSetName() {
        customer.setName("Alice");
        assertEquals("Alice", customer.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testSetAge() {
        customer.setAge(25);
        assertEquals(25, customer.getAge());
    }

    @Test
    public void testToString() {
        assertEquals("Customer [name=John, age=30]", customer.toString());
    }

    @Test
    public void testCopyConstructor() {
        Customer copiedCustomer = new Customer(customer);
        assertEquals(customer.getName(), copiedCustomer.getName());
        assertEquals(customer.getAge(), copiedCustomer.getAge());
    }
}