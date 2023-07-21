package HomeWork8;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    private String type;
    private double price;
    private boolean discountApplicable;
    private LocalDate addedDate;

    public Product(String type, double price, boolean discountApplicable, LocalDate addedDate) {
        this.type = type;
        this.price = price;
        this.discountApplicable = discountApplicable;
        this.addedDate = addedDate;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscountApplicable() {
        return discountApplicable;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    //Using Stream API
    public static List<Product> getBooksWithPriceAbove100(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() > 100)
                .collect(Collectors.toList());
    }

    //Using Stream API
    public static List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.isDiscountApplicable())
                .map(product -> {
                    // Apply a 10% discount to the price
                    double discountedPrice = product.getPrice() * 0.9;
                    return new Product(product.getType(), discountedPrice, false, product.getAddedDate());
                })
                .collect(Collectors.toList());
    }

    //Using Stream API
    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Product [Book] not found"));
    }

    //Using Stream API
    public static List<Product> getLastThreeAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getAddedDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    //Using Stream API
    public static double calculateTotalCost(List<Product> products) {
        LocalDate currentDate = LocalDate.now();
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() <= 75 && product.getAddedDate().getYear() == currentDate.getYear())
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
