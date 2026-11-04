package org.example;

public class App {
    void main() {
        Employee[] employees = {
                new Manager("Иванов Пётр", 4200.00, 9, 12),
                new Manager("Сидорова Анна", 3800.50, 6, 8),
                new Manager("Кравцов Дмитрий", 4500.00, 11, 20),
                new Developer("Ковалёв Артём", 3600.00, 4, "Java"),
                new Developer("Новик Максим", 3300.75, 2, "C#")
        };

        for (int i = 0; i < employees.length; i++) {
            IO.println("=== Сотрудник " + (i + 1) + " ===");
            employees[i].displayInfo();
            employees[i].work();

            switch (employees[i]) {
                case Manager manager -> manager.holdMeeting();
                case Developer developer -> developer.debugCode();
                default -> IO.println("Уникальных методов нет");
            }

            IO.println();
        }

        IO.println("=== Работа геттеров и сеттеров ===");
        Employee first = employees[0];
        IO.println("Зарплата до: %.2f".formatted(first.getSalary()));
        first.setSalary(first.getSalary() * 1.1);
        IO.println("Зарплата после повышения на 10%%: %.2f".formatted(first.getSalary()));

        if (employees[3] instanceof Developer developer) {
            developer.setLanguage("Kotlin");
            developer.work();
        }
    }
}