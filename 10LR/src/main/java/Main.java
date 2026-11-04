import org.example.Calculatable;
import org.example.Circle;
import org.example.Drawable;
import org.example.Rectangle;

void main() {
    List<Calculatable> shapes = List.of(
            new Circle("Красный", 3.0, 0, 0),
            new Circle("Синий", 1.5, 4, 2),
            new Circle("Зелёный", 5.0, -3, 7),
            new Rectangle("Жёлтый", 4.0, 6.0, 1, 1),
            new Rectangle("Чёрный", 2.5, 8.0, -2, 5)
    );

    IO.println("=== Отрисовка фигур ===");
    for (Calculatable shape : shapes) {
        if (shape instanceof Drawable drawable) {
            drawable.draw();
        }
    }

    IO.println();
    IO.println("=== Площади и периметры ===");
    int number = 1;
    for (Calculatable shape : shapes) {
        IO.println(number + ". " + shape
                + " | площадь = " + Calculatable.format(shape.calculateArea())
                + " | периметр = " + Calculatable.format(shape.calculatePerimeter()));
        number++;
    }

    IO.println();
    IO.println("=== Сравнение фигур по площади ===");
    Comparable first = (Comparable) shapes.get(0);
    Comparable second = (Comparable) shapes.get(3);
    Comparable third = (Comparable) shapes.get(2);

    printComparison(first, shapes.get(0), shapes.get(3));
    printComparison(second, shapes.get(3), shapes.get(0));
    printComparison(third, shapes.get(2), shapes.get(2));
}

void printComparison(Comparable left, Object leftShape, Object rightShape) {
    int result = left.compareTo(rightShape);
    String text = switch (Integer.signum(result)) {
        case -1 -> "меньше площади";
        case 1 -> "больше площади";
        default -> "равна площади";
    };
    IO.println(leftShape + ": площадь " + text + " фигуры " + rightShape);
}