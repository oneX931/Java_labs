import org.example.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

void main() {
    boolean running = true;
    while (running) {
        System.out.println();
        String choice = IO.readln("Выберите задание: ");
        if (choice == null) {
            break;
        }
        IO.println();
        switch (choice.strip()) {
            case "1" -> {
                Map<String, Animal> animals = new LinkedHashMap<>();

                Animal[] list = {
                        new Dog("Rex", 1, 5, "Овчарка"),
                        new Dog("Buddy", 2, 3, "Лабрадор"),
                        new Dog("Charlie", 3, 7, "Бульдог"),
                        new Cat("Murka", 4, 2, "Рыжий"),
                        new Cat("Tom", 5, 4, "Серый"),
                        new Cat("Luna", 6, 1, "Чёрный"),
                        new Bird("Kesha", 7, 2, 0.3),
                        new Bird("Eagle", 8, 6, 2.1)
                };
                for (Animal animal : list) {
                    animals.put(animal.getName(), animal);
                }

                IO.println("Ключи:");
                for (String key : animals.keySet()) {
                    IO.println("  " + key);
                }

                IO.println();
                IO.println("Ключ -> значение:");
                animals.forEach((key, value) -> IO.println("  " + key + " -> " + value));
                var iterator = animals.entrySet().iterator();
                while (iterator.hasNext()) {
                    var entry = iterator.next();
                    IO.println("  " + entry.getKey() + " -> " + entry.getValue());
                }

            }
            case "2" -> {
                List<Product> products = new ArrayList<>(List.of(
                        new Product(1, "Laptop", "Электроника", 4, List.of(5, 4, 5, 4)),
                        new Product(2, "Smartphone", "Электроника", 5, List.of(5, 5, 4, 5)),
                        new Product(3, "Headphones", "Аудио", 3, List.of(4, 4, 4)),
                        new Product(4, "Keyboard", "Аксессуары", 2, List.of(3, 3, 3)),
                        new Product(5, "Mouse", "Аксессуары", 3, List.of(4, 4, 4)),
                        new Product(6, "Old Charger", "Аксессуары", 1, List.of(1, 2, 2)),
                        new Product(7, "Cheap Cable", "Аксессуары", 2, List.of(2, 3, 2)),
                        new Product(8, "Monitor", "Электроника", 4, List.of(4, 5, 3, 4))
                ));

                IO.println("Исходный список:");
                products.forEach(product -> IO.println("  " + product));

                IO.println();
                IO.println("1. Удаление товаров со средним рейтингом < 3");
                ProductOperations.removeLowRated(products);
                products.forEach(product -> IO.println("  " + product));

                IO.println();
                IO.println("2. Повышение рейтинга товаров со средним рейтингом >= 4");
                ProductOperations.raiseHighRated(products);
                products.forEach(product -> IO.println("  " + product));

                IO.println();
                IO.println("3. Печать товаров по рейтингу");
                ProductOperations.printProducts(products, 5);
                ProductOperations.printProducts(products, 4);
                ProductOperations.printProducts(products, 3);

                IO.println();
                IO.println("4. Упорядочивание по убыванию среднего рейтинга");
                ProductOperations.sortByAverageRating(products);
                ProductOperations.printRanking(products);
            }
            case "0" -> running = false;
            default -> IO.println("Неверный выбор, введите 0, 1 или 2");
        }
    }
    IO.println("Программа завершена");
}