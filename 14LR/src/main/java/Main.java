final Path DIR = Path.of("lab14_files");
final Random random = new Random();
final int RANDOM_COUNT = 30;
final int THRESHOLD = 50;

void main() {
    IO.println("Файловый ввод и вывод в Java");
    boolean running = true;
    while (running) {
        IO.println("""

                ===== МЕНЮ =====
                1 - Файл со сведениями о специальности
                2 - Ввод 10 целых чисел в файл, сумма чисел
                3 - Случайные числа: g (больше 50) и h (не больше 50)
                4 - Скорость ветра: средняя скорость
                5 - Случайные числа: количество нулей
                0 - Выход
                """);
        String choice = IO.readln("Выберите задание: ");
        if (choice == null) {
            break;
        }
        try {
            switch (choice.strip()) {
                case "1" -> {
                    IO.println("\n--- Задание 1. Файл о специальности ---");
                    Files.createDirectories(DIR);
                    Path path = DIR.resolve("specialty.txt");
                    String text = """
                            Специальность: Разработка и сопровождение программного обеспечения информационных систем
                            Учреждение образования: колледж Бизнеса и Права
                            Учебная группа: Т-394
                            Курс: 4
                            Квалификация: техник-программист
                            Изучаемые языки: C++, Python, Java, C#, 1С
                            Веб-технологии: HTML, CSS, JavaScript
                            Система управления базами данных: Microsoft SQL Server
                            """;
                    Files.writeString(path, text);

                    File file = path.toFile();
                    IO.println("Данные о файле:");
                    IO.println("Имя файла: " + file.getName());
                    IO.println("Размер: " + file.length() + " байт");
                    IO.println("Родительский каталог: " + file.getParent());
                    IO.println("Путь: " + file.getPath());
                    IO.println("Абсолютный путь: " + file.getAbsolutePath());
                    IO.println("Последнее изменение: " + Files.getLastModifiedTime(path));
                    IO.println("Файл " + (file.exists() ? "существует" : "не существует"));
                    IO.println(file.canRead() ? "Чтение разрешено" : "Чтение запрещено");
                    IO.println(file.canWrite() ? "Запись разрешена" : "Запись запрещена");
                    IO.println("Это " + (file.isDirectory() ? "каталог" : "не каталог"));
                    IO.println("Это " + (file.isFile() ? "обычный файл" : "не обычный файл"));

                    IO.println("\nСодержимое файла:");
                    IO.print(Files.readString(path));
                }
                case "2" -> {
                    IO.println("\n--- Задание 2. Сумма 10 чисел ---");
                    Files.createDirectories(DIR);
                    Path path = DIR.resolve("f2.txt");
                    IO.println("Введите 10 целых чисел.");
                    try (var writer = new PrintWriter(Files.newBufferedWriter(path))) {
                        for (int i = 1; i <= 10; i++) {
                            writer.println(readInt("Число " + i + ": "));
                        }
                    }
                    List<Integer> numbers = Files.readAllLines(path).stream().map(Integer::parseInt).toList();
                    long sum = numbers.stream().mapToLong(Integer::longValue).sum();
                    IO.println("Числа из файла f2.txt: " + numbers);
                    IO.println("Сумма всех чисел: " + sum);
                }
                case "3" -> {
                    IO.println("\n--- Задание 3. Разбиение чисел по порогу " + THRESHOLD + " ---");
                    Files.createDirectories(DIR);
                    Path f = DIR.resolve("f3.txt");
                    Path g = DIR.resolve("g.txt");
                    Path h = DIR.resolve("h.txt");

                    List<String> generated = random.ints(RANDOM_COUNT, 0, 101).mapToObj(String::valueOf).toList();
                    Files.write(f, generated);

                    List<Integer> numbers = Files.readAllLines(f).stream().map(Integer::parseInt).toList();
                    var parts = numbers.stream().collect(Collectors.partitioningBy(n -> n > THRESHOLD));
                    Files.write(g, parts.get(true).stream().map(String::valueOf).toList());
                    Files.write(h, parts.get(false).stream().map(String::valueOf).toList());

                    IO.println("Файл f3.txt (исходные числа): " + Files.readAllLines(f));
                    IO.println("Файл g.txt (числа, большие " + THRESHOLD + "): " + Files.readAllLines(g));
                    IO.println("Файл h.txt (числа, не превышающие " + THRESHOLD + "): " + Files.readAllLines(h));
                    IO.println("Всего: " + numbers.size() + ", в g: " + parts.get(true).size() + ", в h: " + parts.get(false).size());
                }
                case "4" -> {
                    IO.println("\n--- Задание 4. Средняя скорость ветра ---");
                    Files.createDirectories(DIR);
                    Path path = DIR.resolve("wind.txt");
                    IO.println("Введите 10 значений скорости ветра в м/с (допустима запятая или точка).");
                    try (var writer = new PrintWriter(Files.newBufferedWriter(path))) {
                        for (int i = 1; i <= 10; i++) {
                            writer.println(readSpeed("Скорость " + i + ": "));
                        }
                    }
                    List<Double> speeds = Files.readAllLines(path).stream().map(Double::parseDouble).toList();
                    double average = speeds.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                    IO.println("Значения из файла wind.txt: " + speeds);
                    IO.println("Средняя скорость ветра: %.2f м/с".formatted(average));
                }
                case "5" -> {
                    IO.println("\n--- Задание 5. Количество нулей ---");
                    Files.createDirectories(DIR);
                    Path path = DIR.resolve("f5.txt");
                    List<String> generated = random.ints(10, -3, 4).mapToObj(String::valueOf).toList();
                    Files.write(path, generated);

                    List<Integer> numbers = Files.readAllLines(path).stream().map(Integer::parseInt).toList();
                    long zeros = numbers.stream().filter(n -> n == 0).count();
                    IO.println("Числа из файла f5.txt: " + numbers);
                    IO.println("Количество чисел, равных нулю: " + zeros);
                }
                case "0" -> {
                    IO.println("Работа завершена.");
                    running = false;
                }
                default -> IO.println("Такого пункта нет в меню, повторите выбор.");
            }
        } catch (IOException e) {
            IO.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (IllegalStateException e) {
            IO.println(e.getMessage());
            running = false;
        }
    }
}

int readInt(String prompt) {
    while (true) {
        String line = IO.readln(prompt);
        if (line == null) {
            throw new IllegalStateException("Ввод прерван, программа завершена.");
        }
        try {
            return Integer.parseInt(line.strip());
        } catch (NumberFormatException _) {
            IO.println("Ошибка: нужно ввести целое число.");
        }
    }
}

double readSpeed(String prompt) {
    while (true) {
        String line = IO.readln(prompt);
        if (line == null) {
            throw new IllegalStateException("Ввод прерван, программа завершена.");
        }
        try {
            double value = Double.parseDouble(line.strip().replace(',', '.'));
            if (Double.isFinite(value) && value >= 0) {
                return value;
            }
            IO.println("Ошибка: скорость ветра не может быть отрицательной.");
        } catch (NumberFormatException _) {
            IO.println("Ошибка: нужно ввести вещественное число.");
        }
    }
}