package org.example;

public class ProductNotFoundException extends Exception {
    private final String productName;

    public ProductNotFoundException(String message, String productName) {
        super(message);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}