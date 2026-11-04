import org.example.Animal;
import org.example.Bird;
import org.example.Dog;

void main() {
    demonstrateAbstractClass();

    IO.println("\n=== Создание объектов ===");
    List<Animal> animals = List.of(
            new Dog("Шарик", 3, 25.5, "Овчарка"),
            new Dog("Бобик", 5, 12.0, "Бигль"),
            new Bird("Кеша", 2, 0.12, 25.0),
            new Bird("Гоша", 1, 0.09, 22.5),
            new Bird("Чижик", 4, 0.015, 18.0)
    );

    IO.println("\n=== Звуки и способы передвижения ===");
    for (Animal animal : animals) {
        String kind = switch (animal) {
            case Dog _ -> "Собака";
            case Bird _ -> "Птица";
            default -> "Животное";
        };
        IO.println("\n[" + kind + "]");
        animal.displayInfo();
        animal.makeSound();
        animal.move();
    }

    IO.println("\n=== Дополнительные методы ===");
    Animal first = animals.getFirst();
    first.feed(0.5);
    first.celebrateBirthday();

    if (animals.get(2) instanceof Bird bird) {
        bird.setWingSpan(26.5);
        IO.println("Новый размах крыльев у " + bird.getName() + ": " + bird.getWingSpan() + " см");
    }

    double totalWeight = animals.stream().mapToDouble(Animal::getWeight).sum();
    IO.println("Общий вес всех животных: %.2f кг".formatted(totalWeight));
}

void demonstrateAbstractClass() {
    IO.println("=== Абстрактный класс нельзя инстанцировать ===");
    IO.println("Animal абстрактный: " + Modifier.isAbstract(Animal.class.getModifiers()));
    try {
        Animal.class
                .getDeclaredConstructor(String.class, int.class, double.class)
                .newInstance("Тест", 1, 1.0);
    } catch (InstantiationException e) {
        IO.println("Ошибка при создании Animal: " + e);
    } catch (ReflectiveOperationException e) {
        IO.println("Другая ошибка: " + e);
    }
}