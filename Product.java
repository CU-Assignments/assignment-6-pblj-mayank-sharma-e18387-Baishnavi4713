import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("TV", "Electronics", 800),
            new Product("Sofa", "Furniture", 1500),
            new Product("Chair", "Furniture", 300),
            new Product("T-shirt", "Clothing", 50),
            new Product("Jeans", "Clothing", 70)
        );

        // Group by category
        System.out.println("\nProducts grouped by category:");
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // Most expensive product in each category
        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> mostExpensiveInCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparing(Product::getPrice))
            ));
        mostExpensiveInCategory.forEach((category, product) -> 
            System.out.println(category + ": " + product.get()));

        // Average price of all products
        double avgPrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0.0);

        System.out.println("\nAverage price of all products: " + avgPrice);
    }
}
