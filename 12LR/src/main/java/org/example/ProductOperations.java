package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public final class ProductOperations {
    private ProductOperations() {
    }

    public static void removeLowRated(List<Product> products) {
        products.removeIf(product -> product.getAverageRating() < 3);
    }

    public static void raiseHighRated(List<Product> products) {
        for (Product product : products) {
            if (product.getAverageRating() >= 4) {
                product.setRating(product.getRating() + 1);
            }
        }
    }

    public static void printProducts(List<Product> products, int rating) {
        IO.println("Товары с рейтингом " + rating + ":");
        List<Product> matched = products.stream()
                .filter(product -> product.getRating() == rating)
                .toList();
        if (matched.isEmpty()) {
            IO.println("  таких товаров нет");
            return;
        }
        matched.forEach(product -> IO.println("  " + product));
    }

    public static void sortByAverageRating(List<Product> products) {
        products.sort(Comparator.comparingDouble(Product::getAverageRating).reversed().thenComparing(
                                Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER).reversed()
                        )
        );
    }


    public static void printRanking(List<Product> products) {
        for (Product product : products) {
            IO.println(String.format(Locale.US, "  ID=%d | %s | %.2f",
                    product.getId(), product.getName(), product.getAverageRating()));
        }
    }
}
