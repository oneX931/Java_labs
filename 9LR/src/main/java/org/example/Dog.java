package org.example;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight);
        this.breed = breed;
        IO.println("Конструктор Dog вызван");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        IO.println("Гав-гав!");
    }

    @Override
    public void move() {
        IO.println("Бегает на четырёх лапах");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        IO.println("Порода: " + breed);
    }
}