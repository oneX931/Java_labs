package org.example;

public class Circle implements Drawable, Calculatable, Comparable {
    private final String color;
    private final double radius;
    private final double x;
    private final double y;

    public Circle(String color, double radius, double x, double y) {
        this.color = color;
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        IO.println("Рисую круг: цвет " + color + ", радиус " + radius
                + ", центр (" + x + "; " + y + ")");
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Calculatable other) {
            return Double.compare(calculateArea(), other.calculateArea());
        }
        throw new IllegalArgumentException("Объект не поддерживает вычисление площади");
    }

    @Override
    public String toString() {
        return "Круг (" + color + ", r=" + radius + ")";
    }
}