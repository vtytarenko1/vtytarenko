package coffee.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CoffeeOrderBoardTest {
    private CoffeeOrderBoard orderBoard;

    @BeforeEach
    public void setUp() {
        orderBoard = new CoffeeOrderBoard();
    }

    @Test
    public void testAddOrder() {
        Order order1 = new Order("Alice");
        orderBoard.add(order1);
        assertEquals(1, orderBoard.getOrderQueueSize());
    }

    @Test
    public void testDeliverOrder() {
        Order order1 = new Order("Bob");
        orderBoard.add(order1);
        Order deliveredOrder = orderBoard.deliver();
        assertEquals("Bob", deliveredOrder.getCustomerName());
        assertEquals(0, orderBoard.getOrderQueueSize());
    }

    @Test
    public void testDeliverSpecificOrder() {
        Order order1 = new Order("Charlie");
        orderBoard.add(order1);
        Order specificOrder = orderBoard.deliver(order1.getOrderNumber());
        assertEquals("Charlie", specificOrder.getCustomerName());
        assertEquals(0, orderBoard.getOrderQueueSize());
    }

    @Test
    public void testDeliverSpecificOrderNotFound() {
        Order order1 = new Order("David");
        orderBoard.add(order1);
        Order specificOrder = orderBoard.deliver(123); // Assuming 123 doesn't exist
        assertNull(specificOrder);
    }

    @Test
    public void testDrawOrderQueue() {
        Order order1 = new Order("Eve");
        Order order2 = new Order("Frank");
        orderBoard.add(order2);
        orderBoard.add(order1);
        String expectedOutput = "Current order queue:\n" + order1.getOrderNumber() + " | Eve\n" + order2.getOrderNumber() + " | Frank\n";
        assertEquals(expectedOutput, orderBoard.drawOrderQueue());
    }
}
