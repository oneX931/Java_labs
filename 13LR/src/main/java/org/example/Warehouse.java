package org.example;

import java.io.IO;
import java.util.LinkedHashMap;
import java.util.Map;

public class Warehouse {
    private final Map<String, Product> products = new LinkedHashMap<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Товар не может быть null");
        }
        String key = normalize(product.getName());
        if (products.containsKey(key)) {
            throw new IllegalStateException("Товар уже есть на складе: " + product.getName());
        }
        products.put(key, product);
    }

    public Product findProduct(String name) throws ProductNotFoundException {
        Product product = products.get(normalize(name));
        if (product == null) {
            throw new ProductNotFoundException("Товар не найден на складе", name);
        }
        return product;
    }

    public double purchase(String name, int amount) throws ProductNotFoundException, OutOfStockException {
        Product product = findProduct(name);
        double cost = product.getPrice() * amount;
        product.reduceQuantity(amount);
        return cost;
    }

    public void updatePrice(String name, double percent) throws ProductNotFoundException, InvalidPriceException {
        findProduct(name).increasePrice(percent);
    }

    public void printAll() {
        if (products.isEmpty()) {
            IO.println("Склад пуст");
            return;
        }
        for (Product product : products.values()) {
            IO.println(product);
        }
    }

    private String normalize(String name) {
        return name == null ? "" : name.strip().toLowerCase();
    }
}