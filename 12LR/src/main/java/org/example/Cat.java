package org.example;

public final class Cat extends Animal {
    private final String color;

    public Cat(String name, int id, int age, String color) {
        super(name, id, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    protected String extraInfo() {
        return "color=" + color;
    }
}
