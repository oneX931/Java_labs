package org.example;

public abstract class Animal {
    private String name;
    private int age;
    private double weight;

    public Animal(String name, int age, double weight) {
        setName(name);
        setAge(age);
        setWeight(weight);
        IO.println("Конструктор Animal вызван для: " + name);
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Кличка не может быть пустой");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public final void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public final void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес должен быть положительным");
        }
        this.weight = weight;
    }

    public abstract void makeSound();

    public abstract void move();

    public void celebrateBirthday() {
        age++;
        IO.println(name + " отметил день рождения, теперь ему " + age);
    }

    public void feed(double amount) {
        if (amount <= 0) {
            IO.println("Количество корма должно быть положительным");
            return;
        }
        weight += amount;
        IO.println("%s поел, вес теперь %.2f кг".formatted(name, weight));
    }

    public void displayInfo() {
        IO.println("Кличка: %s, возраст: %d, вес: %.2f кг".formatted(name, age, weight));
    }
}