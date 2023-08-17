package coffee.order;

import java.util.*;
import java.util.logging.*;

public class CoffeeOrderBoard {
    private PriorityQueue<Order> orderQueue;
    private Logger logger;

    public CoffeeOrderBoard() {
        orderQueue = new PriorityQueue<>();
        logger = Logger.getLogger(CoffeeOrderBoard.class.getName());

        // Configure logging
        ConsoleHandler consoleHandler = new ConsoleHandler();
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("coffee_order_log.txt");
            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);
            logger.setLevel(Level.ALL);
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Order order) {
        orderQueue.add(order);
        logger.info("Added order: " + order.getCustomerName());
    }

    public Order deliver() {
        Order order = orderQueue.poll();
        logger.info("Delivered order: " + order.getCustomerName());
        return order;
    }

    public Order deliver(int orderNumber) {
        Order targetOrder = null;
        for (Order order : orderQueue) {
            if (order.getOrderNumber() == orderNumber) {
                targetOrder = order;
                orderQueue.remove(order);
                break;
            }
        }
        if (targetOrder != null) {
            logger.info("Delivered order with specific number: " + targetOrder.getCustomerName());
        } else {
            logger.warning("Requested order with number " + orderNumber + " not found");
        }
        return targetOrder;
    }

    public void draw() {
        logger.info("Current order queue:");
        for (Order order : orderQueue) {
            logger.info(String.format("%d | %s", order.getOrderNumber(), order.getCustomerName()));
        }
    }
}

