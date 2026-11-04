package org.example;

public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double salary, int experience, int teamSize) {
        super(name, salary, experience);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public void work() {
        IO.println("Управляет командой из " + teamSize + " человек");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        IO.println("Размер команды: " + teamSize);
    }

    public void holdMeeting() {
        IO.println(getName() + " проводит собрание с командой из " + teamSize + " человек");
    }
}