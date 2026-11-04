package org.example;

public class Rectangle implements Drawable, Calculatable, Comparable {
    private final String color;
    private final double width;
    private final double height;
    private final double x;
    private final double y;

    public Rectangle(String color, double width, double height, double x, double y) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        IO.println("Рисую прямоугольник: цвет " + color + ", ширина " + width
                + ", высота " + height + ", угол (" + x + "; " + y + ")");
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
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
        return "Прямоугольник (" + color + ", " + width + "x" + height + ")";
    }
}