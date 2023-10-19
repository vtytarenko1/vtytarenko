package coffee.order;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CoffeeOrderBoardTest {
    private CoffeeOrderBoard orderBoard;

    @Before
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
        orderBoard.add(order2);  // Спочатку додайте order2
        orderBoard.add(order1);  // А потім order1
        String expectedOutput = "1 | Frank\n2 | Eve\n";
        assertEquals(expectedOutput, orderBoard.drawOrderQueue());
    }
}
