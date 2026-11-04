package org.example;

public class Bird extends Animal {
    private double wingSpan;

    public Bird(String name, int age, double weight, double wingSpan) {
        super(name, age, weight);
        this.wingSpan = wingSpan;
        IO.println("Конструктор Bird вызван");
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    @Override
    public void makeSound() {
        IO.println("Чирик-чирик!");
    }

    @Override
    public void move() {
        IO.println("Летает в небе");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        IO.println("Размах крыльев: %.1f см".formatted(wingSpan));
    }
}