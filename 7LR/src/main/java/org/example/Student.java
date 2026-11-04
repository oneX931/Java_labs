static class Student {
    private static int totalStudents;
    private static int totalCourses;

    private final String name;
    private final int course;
    private final String group;

    Student(String name, int course, String group) {
        this.name = name;
        this.course = course;
        this.group = group;
        totalStudents++;
        totalCourses += course;
    }

    static int getTotalStudents() {
        return totalStudents;
    }

    static int getTotalCourses() {
        return totalCourses;
    }

    static double getAverageCourse() {
        if (totalStudents == 0) {
            return 0;
        }
        return (double) totalCourses / totalStudents;
    }

    String getInfo() {
        return "%s, %d курс, группа %s".formatted(name, course, group);
    }
}

void main() {
    IO.println("Студентов до создания объектов: " + Student.getTotalStudents());
    IO.println("Средний курс до создания объектов: " + Student.getAverageCourse());
    IO.println();

    var students = List.of(
            new Student("Иван Петров", 4, "Т-394"),
            new Student("Анна Козлова", 4, "Т-394"),
            new Student("Дмитрий Сидоров", 3, "Т-293"),
            new Student("Мария Ковалёва", 2, "Т-192"),
            new Student("Алексей Новик", 3, "Т-293"),
            new Student("Ольга Лукашевич", 1, "Т-091")
    );

    IO.println("Список студентов:");
    for (var student : students) {
        IO.println(" - " + student.getInfo());
    }

    IO.println();
    IO.println("Всего студентов: " + Student.getTotalStudents());
    IO.println("Сумма курсов: " + Student.getTotalCourses());
    IO.println("Средний курс: %.2f".formatted(Student.getAverageCourse()));
}