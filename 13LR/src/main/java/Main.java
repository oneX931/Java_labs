import org.example.InvalidPriceException;
import org.example.OperationLog;
import org.example.OutOfStockException;
import org.example.Product;
import org.example.ProductNotFoundException;
import org.example.Purchase;
import org.example.Warehouse;

import java.io.IO;
import java.util.List;
import java.util.Map;

void main() {
    Warehouse warehouse = new Warehouse();
    fillWarehouse(warehouse);
    IO.println("=== Начальное состояние склада ===");
    warehouse.printAll();
    checkInvalidProducts();
    makePurchases(warehouse);
    updatePrices(warehouse);
    runWithJournal(warehouse);
    IO.println("=== Итоговое состояние склада ===");
    warehouse.printAll();
}

private Product createProduct(String name, double price, int quantity, String category) throws InvalidPriceException {
    if (name == null || name.isBlank()) {
        throw new IllegalArgumentException("Название товара не может быть пустым");
    }
    if (category == null || category.isBlank()) {
        throw new IllegalArgumentException("Категория товара не может быть пустой");
    }
    if (!Double.isFinite(price) || price <= 0) {
        throw new InvalidPriceException("Цена должна быть больше нуля", price);
    }
    if (quantity < 0) {
        throw new IllegalArgumentException("Количество не может быть отрицательным: " + quantity);
    }
    return new Product(name.strip(), price, quantity, category.strip());
}

private void fillWarehouse(Warehouse warehouse) {
    try {
        warehouse.addProduct(createProduct("Ноутбук", 2499.90, 5, "Электроника"));
        warehouse.addProduct(createProduct("Смартфон", 1599.00, 3, "Электроника"));
        warehouse.addProduct(createProduct("Наушники", 189.50, 20, "Аксессуары"));
        warehouse.addProduct(createProduct("Монитор", 649.00, 8, "Электроника"));
        warehouse.addProduct(createProduct("Клавиатура", 129.00, 0, "Аксессуары"));
    } catch (InvalidPriceException e) {
        IO.println("Ошибка при создании товара: " + e.getMessage() + " (цена: " + e.getPrice() + ")");
    }
}

private void checkInvalidProducts() {
    IO.println("=== Проверка создания товаров ===");
    try {
        createProduct("Мышь", 0, 10, "Периферия");
    } catch (InvalidPriceException e) {
        IO.println("InvalidPriceException: " + e.getMessage() + ", цена = " + e.getPrice());
    } finally {
        IO.println("Проверка цены завершена");
    }
    try {
        createProduct("Мышь", 35.50, -3, "Периферия");
    } catch (InvalidPriceException | IllegalArgumentException e) {
        IO.println(e.getClass().getSimpleName() + ": " + e.getMessage());
    }
    try {
        createProduct("   ", 35.50, 3, "Периферия");
    } catch (InvalidPriceException | IllegalArgumentException e) {
        IO.println(e.getClass().getSimpleName() + ": " + e.getMessage());
    }
}

private void makePurchases(Warehouse warehouse) {
    IO.println("=== Покупки ===");
    List<Purchase> purchases = List.of(
            new Purchase("Ноутбук", 2),
            new Purchase("Смартфон", 5),
            new Purchase("Планшет", 1),
            new Purchase("Монитор", 0),
            new Purchase("Ноутбук", 3),
            new Purchase("Ноутбук", 1),
            new Purchase("Клавиатура", 1)
    );
    double revenue = 0;
    for (Purchase purchase : purchases) {
        try {
            double cost = warehouse.purchase(purchase.name(), purchase.amount());
            revenue += cost;
            IO.println("Куплено: " + purchase.name() + " x" + purchase.amount()
                    + ", стоимость " + "%.2f BYN".formatted(cost));
        } catch (ProductNotFoundException e) {
            IO.println("Не найден: " + e.getProductName());
        } catch (OutOfStockException e) {
            IO.println(e.getMessage() + ": " + e.getProductName()
                    + ", запрошено " + e.getRequested() + ", доступно " + e.getAvailable());
        } catch (IllegalArgumentException e) {
            IO.println("Некорректная заявка: " + e.getMessage());
        } finally {
            IO.println("Заявка обработана: " + purchase);
        }
    }
    IO.println("Выручка: " + "%.2f BYN".formatted(revenue));
}

private void updatePrices(Warehouse warehouse) {
    IO.println("=== Обновление цен ===");
    List<Map.Entry<String, Double>> changes = List.of(
            Map.entry("Смартфон", 10.0),
            Map.entry("Наушники", -15.0),
            Map.entry("Монитор", -100.0),
            Map.entry("Планшет", 5.0),
            Map.entry("Наушники", -250.0)
    );
    for (var change : changes) {
        try {
            warehouse.updatePrice(change.getKey(), change.getValue());
            Product product = warehouse.findProduct(change.getKey());
            IO.println("Цена обновлена (" + change.getValue() + "%): " + product);
        } catch (ProductNotFoundException _) {
            IO.println("Товар для обновления цены не найден: " + change.getKey());
        } catch (InvalidPriceException e) {
            IO.println("Цена не обновлена для \"" + change.getKey() + "\": "
                    + e.getMessage() + " (получилось " + e.getPrice() + ")");
        }
    }
}

private void runWithJournal(Warehouse warehouse) {
    IO.println("=== Журнал операций (try-with-resources) ===");
    try (OperationLog log = new OperationLog("Вечерняя смена")) {
        warehouse.purchase("Наушники", 4);
        log.record("Наушники x4 проданы");
        warehouse.purchase("Монитор", 20);
        log.record("Мониторы x20 проданы");
    } catch (ProductNotFoundException | OutOfStockException e) {
        IO.println("Операция прервана: " + describe(e));
    }
}

private String describe(Exception e) {
    return switch (e) {
        case ProductNotFoundException p -> "не найден товар " + p.getProductName();
        case OutOfStockException o -> "нет в наличии: " + o.getProductName()
                + " (запрошено " + o.getRequested() + ", доступно " + o.getAvailable() + ")";
        case InvalidPriceException i -> "неверная цена " + i.getPrice();
        default -> "прочая ошибка: " + e.getMessage();
    };
}