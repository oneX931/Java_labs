package org.example;

public abstract sealed class Animal permits Dog, Cat, Bird {
    private final String name;
    private final int id;
    private final int age;

    protected Animal(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    protected abstract String extraInfo();

    @Override
    public String toString() {
        return "%s{name=%s, id=%d, age=%d, %s}".formatted(
                getClass().getSimpleName(), name, id, age, extraInfo());
    }
}
