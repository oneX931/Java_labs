package org.example;

public class Vehicle {
    protected String brand;
    protected int year;
    protected double speed;

    public Vehicle(String brand, int year, double speed) {
        this.brand = brand;
        this.year = year;
        this.speed = speed;
    }

    public String move() {
        return "Транспорт движется";
    }

    public String move(int distance) {
        return "Транспорт проехал " + distance + " км";
    }

    public String move(String destination) {
        return "Транспорт едет в " + destination;
    }

    public double getSpeed() {
        return speed;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "%s %s (%d г.)".formatted(getClass().getSimpleName(), brand, year);
    }
}