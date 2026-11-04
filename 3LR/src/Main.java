record Employee(String fullname, double salary) {
}

static class Report {
    static void generateReport(Employee[] employees) {
        for (var e : employees) {
            IO.println(String.format("%-30s%10.2f", e.fullname(), e.salary()));
        }
    }
}

void main() {
    var running = true;

    while (running) {
        IO.print("Выбор: ");
        var choice = Integer.parseInt(IO.readln());

        switch (choice) {
            case 1 -> {
                IO.print("Введите строку: ");
                var str = IO.readln();

                var last = str.charAt(str.length() - 1);
                IO.println("Последний символ: " + last);
            }
            case 2 -> {
                IO.print("Введите предложение: ");
                var sentence = IO.readln();

                var words = sentence.split(" ");
                var shortest = words[0];

                for (var word : words) {
                    if (word.length() < shortest.length()) {
                        shortest = word;
                    }
                }

                IO.println("Самое короткое слово: " + shortest);
            }
            case 3 -> {
                var surnames = new String[]{"Иванов", "Петров", "Сидоров", "Кузнецов", "Смирнов", "Волков"};
                var names = new String[]{"Алексей", "Дмитрий", "Сергей", "Анна", "Ольга", "Мария"};
                var patronymics = new String[]{"Иванович", "Петрович", "Сергеевич", "Игоревна", "Андреевна", "Дмитриевна"};

                var employees = new Employee[5];
                var random = new Random();

                for (var i = 0; i < employees.length; i++) {
                    var fullname = surnames[random.nextInt(surnames.length)] + " "
                            + names[random.nextInt(names.length)] + " "
                            + patronymics[random.nextInt(patronymics.length)];
                    var salary = 500 + random.nextDouble() * 2500;
                    employees[i] = new Employee(fullname, salary);
                }

                IO.println("Сгенерированные сотрудники:");
                for (var e : employees) {
                    IO.println(e.fullname() + " - " + String.format("%.2f", e.salary()));
                }

                IO.println("");
                IO.println("Отчёт:");
                Report.generateReport(employees);
            }
            case 4 -> {
                var text = "aAXa aeffa aGha aza ax23a a3sSa";
                IO.println("Строка: " + text);

                var pattern = Pattern.compile("a[a-z0-9]+a");
                var matcher = pattern.matcher(text);

                IO.println("Найденные подстроки:");
                while (matcher.find()) {
                    IO.println(matcher.group());
                }
            }
            case 0 -> running = false;
            default -> IO.println("Неверный пункт меню");
        }
        IO.println("");
    }
}