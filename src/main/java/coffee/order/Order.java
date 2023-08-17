package coffee.order;

public class Order implements Comparable<Order> {
    private static int orderCounter = 1;

    private int orderNumber;
    private String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
        this.orderNumber = orderCounter++;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNumber, other.orderNumber);
    }
}
