package org.example;

public class App {

    static void main() {
        boolean running = true;

        while (running) {
            String choice = IO.readln("Выберите задание: ");

            if (choice == null) {
                break;
            }

            switch (choice.trim()) {
                case "1" -> {
                    IO.println("");
                    IO.println("--- Задание 1: Прямоугольник ---");

                    Rectangle first = new Rectangle(5, 3);
                    Rectangle second = new Rectangle(10.5, 2.5);
                    Rectangle third = new Rectangle(7, 7);

                    first.displayInfo();
                    second.displayInfo();
                    third.displayInfo();
                }
                case "2" -> {
                    IO.println("");
                    IO.println("--- Задание 2: Книги ---");

                    Book[] books = {
                            new Book("Война и мир", "Лев Толстой", 1869),
                            new Book("Преступление и наказание", "Фёдор Достоевский", 1866),
                            new Book("Мастер и Маргарита", "Михаил Булгаков", 1967),
                            new Book("1984", "Джордж Оруэлл", 1949),
                            new Book("Метро 2033", "Дмитрий Глуховский", 2005)
                    };

                    IO.println("Все книги:");
                    for (Book book : books) {
                        IO.println(book);
                    }

                    Book oldest = books[0];
                    Book newest = books[0];

                    for (Book book : books) {
                        if (book.getYear() < oldest.getYear()) {
                            oldest = book;
                        }
                        if (book.getYear() > newest.getYear()) {
                            newest = book;
                        }
                    }

                    IO.println("");
                    IO.println("Самая старая книга: " + oldest);
                    IO.println("Самая новая книга: " + newest);
                }
                case "3" -> {
                    IO.println("");
                    IO.println("--- Задание 3: Enum Gender ---");

                    Person man = new Person("Алексей Ковалёв", Gender.MALE);
                    Person woman = new Person("Мария Новик", Gender.FEMALE);

                    IO.println(man);
                    IO.println(woman);

                    IO.println("");
                    IO.println("Все значения перечисления Gender:");
                    for (Gender gender : Gender.values()) {
                        IO.println(gender.ordinal() + " - " + gender.name() + " (" + gender.getTitle() + ")");
                    }
                }
                case "0" -> {
                    running = false;
                    IO.println("Выход из программы.");
                }
                default -> IO.println("Неверный выбор. Введите число от 0 до 3.");
            }
        }
    }
}

