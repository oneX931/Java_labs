package org.example;

public final class Dog extends Animal {
    private final String breed;

    public Dog(String name, int id, int age, String breed) {
        super(name, id, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    protected String extraInfo() {
        return "breed=" + breed;
    }
}
