package coffee.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    private Order order;

    @BeforeEach
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
