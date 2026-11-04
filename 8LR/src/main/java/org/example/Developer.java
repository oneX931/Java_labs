package org.example;

public class Developer extends Employee {
    private String language;

    public Developer(String name, double salary, int experience, String language) {
        super(name, salary, experience);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public void work() {
        IO.println("Пишет код на " + language);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        IO.println("Язык программирования: " + language);
    }

    public void debugCode() {
        IO.println(getName() + " отлаживает код на " + language);
    }
}