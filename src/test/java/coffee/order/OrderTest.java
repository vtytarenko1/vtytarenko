package coffee.order;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    private Order order;

    @Before
    public void setUp() {
        order = new Order("Alice");
    }

    @Test
    public void testGetOrderNumber() {
        assertEquals(1, order.getOrderNumber());
    }

    @Test
    public void testGetCustomerName() {
        assertEquals("Alice", order.getCustomerName());
    }
}
