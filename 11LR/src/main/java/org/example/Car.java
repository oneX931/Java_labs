package org.example;

public class Car extends Vehicle {
    private final int doors;

    public Car(String brand, int year, double speed, int doors) {
        super(brand, year, speed);
        this.doors = doors;
    }

    @Override
    public String move() {
        return "Автомобиль едет по дороге";
    }

    @Override
    public double getSpeed() {
        return speed * 1.0;
    }

    public String move(int distance, int passengers) {
        return "Автомобиль проехал " + distance + " км, пассажиров: " + passengers;
    }

    public String move(String from, String to) {
        return "Автомобиль едет по маршруту " + from + " - " + to;
    }

    public int getDoors() {
        return doors;
    }
}