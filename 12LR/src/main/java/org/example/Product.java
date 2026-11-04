package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class Product {
    private final int id;
    private final String name;
    private final String category;
    private int rating;
    private final List<Integer> customerReviews;

    public Product(int id, String name, String category, int rating, List<Integer> customerReviews) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = Math.clamp(rating, 1, 5);
        this.customerReviews = new ArrayList<>(customerReviews);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<Integer> getCustomerReviews() {
        return List.copyOf(customerReviews);
    }

    public double getAverageRating() {
        return customerReviews.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = Math.clamp(rating, 1, 5);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Product{id=%d, name=%s, category=%s, rating=%d, avg=%.2f}",
                id, name, category, rating, getAverageRating());
    }
}
