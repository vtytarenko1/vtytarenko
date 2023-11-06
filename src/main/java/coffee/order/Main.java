package coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        Order order1 = new Order("Alen");
        Order order2 = new Order("Yoda");
        Order order3 = new Order("Obi-van");
        Order order4 = new Order("John Snow");

        orderBoard.add(order3);
        orderBoard.add(order2);
        orderBoard.add(order1);
        orderBoard.add(order4);

        orderBoard.draw();

        Order deliveredOrder = orderBoard.deliver();
        System.out.println("Delivered: " + deliveredOrder.getCustomerName());

        orderBoard.draw();

        Order specificOrder = orderBoard.deliver(3);
        if (specificOrder != null) {
            System.out.println("Delivered specific: " + specificOrder.getCustomerName());
        }

        orderBoard.draw();
    }
}
