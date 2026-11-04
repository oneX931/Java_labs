package org.example;

public class InvalidPriceException extends Exception {
    private final double price;

    public InvalidPriceException(String message, double price) {
        super(message);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}