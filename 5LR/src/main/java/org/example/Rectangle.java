package org.example;

class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public void displayInfo() {
        IO.println("Ширина: %.2f, высота: %.2f, площадь: %.2f, периметр: %.2f"
                .formatted(width, height, area(), perimeter()));
    }
}
