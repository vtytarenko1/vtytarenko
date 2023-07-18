package HomeWork8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public static List<Product> getBooksWithPriceAbove100(List<Product> products) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getType().equals("Book") && product.getPrice() > 100) {
                result.add(product);
            }
        }
        return result;
    }

    public static List<Product> getDiscountedBooks(List<Product> products) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getType().equals("Book") && product.isDiscountApplicable()) {
                double discountedPrice = product.getPrice() * 0.9;
                Product discountedProduct = new Product(product.getType(), discountedPrice, false, product.getAddedDate());
                result.add(discountedProduct);
            }
        }
        return result;
    }

    public static Product getCheapestBook(List<Product> products) {
        Product cheapestBook = null;
        for (Product product : products) {
            if (product.getType().equals("Book") && (cheapestBook == null || product.getPrice() < cheapestBook.getPrice())) {
                cheapestBook = product;
            }
        }
        if (cheapestBook == null) {
            throw new RuntimeException("Product [Book] not found");
        }
        return cheapestBook;
    }

    public static List<Product> getLastThreeAddedProducts(List<Product> products) {
        products.sort(Comparator.comparing(Product::getAddedDate).reversed());
        return products.subList(0, Math.min(3, products.size()));
    }

    public static double calculateTotalCost(List<Product> products) {
        double totalCost = 0;
        LocalDate currentDate = LocalDate.now();
        for (Product product : products) {
            if (product.getType().equals("Book") && product.getPrice() <= 75 && product.getAddedDate().getYear() == currentDate.getYear()) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }
}
