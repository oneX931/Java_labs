package org.example;

public class Product {
    private final String name;
    private final String category;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public void reduceQuantity(int amount) throws OutOfStockException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Количество для покупки должно быть больше нуля: " + amount);
        }
        if (quantity == 0) {
            throw new OutOfStockException("Товар отсутствует на складе", name, amount, 0);
        }
        if (amount > quantity) {
            throw new OutOfStockException("Недостаточно товара на складе", name, amount, quantity);
        }
        quantity -= amount;
    }

    public void increasePrice(double percent) throws InvalidPriceException {
        double newPrice = Math.round(price * (1 + percent / 100) * 100.0) / 100.0;
        if (!Double.isFinite(newPrice) || newPrice <= 0) {
            throw new InvalidPriceException("Новая цена должна быть больше нуля", newPrice);
        }
        price = newPrice;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "%s [%s]: цена %.2f BYN, остаток %d шт.".formatted(name, category, price, quantity);
    }
}