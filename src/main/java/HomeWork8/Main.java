package HomeWork8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 100, true, LocalDate.of(2023, 1, 1)));
        products.add(new Product("Book", 70, true, LocalDate.of(2023, 2, 15)));
        products.add(new Product("Book", 25, false, LocalDate.of(2023, 3, 20)));
        products.add(new Product("Not a Book", 5, true, LocalDate.of(2023, 4, 25)));

        List<Product> expensiveBooks = Product.getBooksWithPriceAbove100(products);
        System.out.println("Expensive books: " + expensiveBooks);

        List<Product> discountedBooks = Product.getDiscountedBooks(products);
        System.out.println("Discounted books: " + discountedBooks);

        try {
            Product cheapestBook = Product.getCheapestBook(products);
            System.out.println("Cheapest book: " + cheapestBook);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        List<Product> lastThreeProducts = Product.getLastThreeAddedProducts(products);
        System.out.println("Last three added products: " + lastThreeProducts);

        double totalCost = Product.calculateTotalCost(products);
        System.out.println("Total cost of eligible books: " + totalCost);
    }
}
