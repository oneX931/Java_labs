package org.example;

public class OutOfStockException extends Exception {
    private final String productName;
    private final int requested;
    private final int available;

    public OutOfStockException(String message, String productName, int requested, int available) {
        super(message);
        this.productName = productName;
        this.requested = requested;
        this.available = available;
    }

    public String getProductName() {
        return productName;
    }

    public int getRequested() {
        return requested;
    }

    public int getAvailable() {
        return available;
    }
}