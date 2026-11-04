package org.example;

public class Plane extends Vehicle {
    private final int maxAltitude;

    public Plane(String brand, int year, double speed, int maxAltitude) {
        super(brand, year, speed);
        this.maxAltitude = maxAltitude;
    }

    @Override
    public double getSpeed() {
        return speed * 2.0;
    }

    public String move(String destination, int altitude) {
        return "Самолёт летит, пункт назначения: " + destination + ", высота " + altitude + " м";
    }

    public String move(int distance, int altitude) {
        return "Самолёт пролетел " + distance + " км на высоте " + altitude + " м";
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }
}