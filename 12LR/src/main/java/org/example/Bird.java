package org.example;

import java.util.Locale;

public final class Bird extends Animal {
    private final double wingspan;

    public Bird(String name, int id, int age, double wingspan) {
        super(name, id, age);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    @Override
    protected String extraInfo() {
        return String.format(Locale.US, "wingspan=%.1f", wingspan);
    }
}
